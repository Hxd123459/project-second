package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.AuditMapper;
import com.aaa.hjd.mapper.SurveyingUnitMapper;
import com.aaa.hjd.mapper.TUserMapper;
import com.aaa.hjd.model.Audit;
import com.aaa.hjd.model.Score;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.model.TUser;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.utils.IdUtils;
import com.aaa.hjd.utils.ObjectUtil;
import com.aaa.hjd.utils.TimeUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/26  20:55
 * @Description:
 */
@Service
public class AuditService extends BaseService<Audit> {

    @Autowired
    private AuditMapper auditMapper;
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private SurveyingUnitMapper unitMapper;

    /**
     * @Author xxf
     * @Description
     *      多表联查t_user  t_mapping_unit
     *     查询注册审核的单位信息,即在user表中status为锁定的单位信息
     *     分页+搜索
     * @Date 20:59 2020/5/26
     * @Param []
     * @return java.util.List<java.util.HashMap>
     * @throws
     **/
    public PageInfo selectAuditForUnitInfo(HashMap map) {
        //获取分页信息
        Integer pageNum = ObjectUtil.transToInt(map.get("pageNum"));
        Integer pageSize = ObjectUtil.transToInt(map.get("pageSize"));
        //获取搜索信息
        String unitName = ObjectUtil.transToString(map.get("unitName"));
        if (unitName == null || "".equals(unitName)){
            unitName=null;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap> list = auditMapper.selectAuditForUnitInfo(unitName);
        if (list == null || list.size() <= 0 ) {
            return null;
        }
        return new PageInfo(list);
    }

    /**
     * @Author xxf
     * @Description     注册审核
     * @Date 22:48 2020/5/26
     * @Param [map]
     * @return boolean
     * @throws
     **/
    @Transactional(rollbackFor = Exception.class)
    public boolean toAuditForUnit(Audit audit) {
        //生成id
        Long id = IdUtils.getLongID();
        //获取本地时间作为审核时间
        String nowTime = TimeUtils.getNowTimeYMDHMS();
        audit.setName("注册单位审核").setType(5).setAuditTime(nowTime).setId(id);
            try {
                //生成审核记录
                Integer add = super.add(audit);
                //获取审核状态
                Integer status = audit.getStatus();
                //判断审核是否同通过
                    if (status == 0){
                        //审核通过，解锁账号
                        Long userId = audit.getUserId();
                        TUser user = new TUser();
                        user.setStatus("1").setId(userId);
                        Integer integer = tUserMapper.updateUserStatus(user);
                        if (add > 0 && integer > 0) {
                            return true;
                        }
                    }else {
                     //审核不通过
                        if (add > 0) {
                            return true;
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;
    }

    /**
     * @Author xxf
     * @Description
     *      根据userid查询审核记录并分页
     * @Date 10:14 2020/5/28
     * @Param [map]
     * @return com.github.pagehelper.PageInfo<com.aaa.hjd.model.Audit>
     * @throws
     **/
    public PageInfo<Audit> selectAuditByUserId(HashMap map){
        //获取分页信息
        Integer pageNum = ObjectUtil.transToInt(map.get("pageNum"));
        Integer pageSize = ObjectUtil.transToInt(map.get("pageSize"));
        PageHelper.startPage(pageNum,pageSize);
        //获取查询信息
        Long userId = ObjectUtil.transToLong(map.get("userId"));
        List<Audit> audits = auditMapper.selectAuditByUserId(userId);
        //判断查询结果
        if (audits.size() > 0){
            return new PageInfo(audits);
        }
        return null;
    }

    /**
     * @Author xxf
     * @Description
     *      生成修改审核记录
     * @Date 11:00 2020/5/31
     * @Param [audit]
     * @return boolean
     * @throws
     **/
    @Transactional(rollbackFor = Exception.class)
    public boolean insertAudit(Audit audit) {
        //生成id
        Long id = IdUtils.getLongID();
        //获取当前时间作为审核时间
        String nowTime = TimeUtils.getNowTimeYMDHMS();
        audit.setId(id).setAuditTime(nowTime).setType(1).setName("单位信息审核");
        try {
            Integer add = super.add(audit);
            //获取审核状态
            Integer status = audit.getStatus();
                //获取userId
                Long userId = audit.getUserId();
                TMappingUnit unit = new TMappingUnit();
                unit.setUserId(userId).setAuditStatus(status);
                //修改单位表中的审核状态
                //此时审核记录和单位表中的审核状态是一致的
                Integer integer = unitMapper.updateAuditForUnit(unit);
            if (add > 0 && integer > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author xxf
     * @Description
     *  提交审核
     * @Date 17:15 2020/5/31
     * @Param [audit]
     * @return boolean
     * @throws
     **/
    @Transactional(rollbackFor = Exception.class)
    public boolean submitAudit(Audit audit) {
        //生成id
        Long id = IdUtils.getLongID();
        //获取当前时间作为提交时间
        String nowTime = TimeUtils.getNowTimeYMDHMS();
        audit.setId(id).setSubmitTime(nowTime).setType(1).setName("单位信息审核");
        try {
            //生成提交审核记录，此时表中没有审核状态码
            Integer add = super.add(audit);
            //当提交审核，要改变单位表中的审核状态，未提交改为已提交即 3 ==》2
            //获取userId
            Long userId = audit.getUserId();
            TMappingUnit unit = new TMappingUnit();
            unit.setUserId(userId).setAuditStatus(2);
            //修改单位表中的审核状态
            Integer integer = unitMapper.updateAuditForUnit(unit);

            if (add > 0 && integer > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
