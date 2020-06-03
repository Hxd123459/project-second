package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.EquipmentMapper;
import com.aaa.hjd.model.Equipment;
import com.aaa.hjd.model.Technicist;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.utils.IdUtils;
import com.aaa.hjd.utils.ObjectUtil;
import com.aaa.hjd.vo.PageNumAndSize;
import com.aaa.hjd.vo.TokenVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/28
 * 根据用户id获取仪器设备信息
 */
@Service
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取仪器设备信息,根据当前登录用户自己获取
     * @param [session, pageNumAndSize]
     * @return com.github.pagehelper.PageInfo
     * @throws
     */
    public PageInfo getEquipment(HttpSession session, PageNumAndSize pageNumAndSize) {
        //获取tokenVo
        TokenVo tokenVo = (TokenVo)session.getAttribute("tokenVo");
        //RedisKey就是用户的id
        String userId = tokenVo.getRedisKey();
        //转换类型
        Long id = ObjectUtil.transToLong(userId);
        //分页
        PageHelper.startPage(pageNumAndSize.getPageNum(), pageNumAndSize.getPageSize());
        //执行查询
        List<HashMap<String, Object>> list = equipmentMapper.getEquipmentByUserId(id);
        if (0 < list.size()) {
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            //判断成功返回
            return pageInfo;
        }
        return null;
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取仪器设备信息
     * @param [session, pageNumAndSize]
     * @return com.github.pagehelper.PageInfo
     * @throws
     */
    public PageInfo getEquipmentByUserId(HashMap map) {

        //获取相关用户的id，转换类型
        Long id = ObjectUtil.transToLong(map.get("userId"));
        //分页
        PageHelper.startPage(ObjectUtil.transToInt(map.get("pageNum")), ObjectUtil.transToInt(map.get("pageSize")));
        //执行查询
        List<HashMap<String, Object>> list = equipmentMapper.getEquipmentByUserId(id);
        if (0 < list.size()) {
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            //判断成功返回
            return pageInfo;
        }
        return null;
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增设备信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer insertEquipment(Equipment technicist) {

        if (null != technicist) {
            //设置创建时间
            technicist.setCreateTime(DateTimeUtils.getNow());
            //设置主键id
            technicist.setId(IdUtils.getLongID());
            //执行新增
            int result = equipmentMapper.insert(technicist);
            if (0 < result) {
                return result;
            }
        }
        return null;
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 修改设备信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer updateEquipment(Equipment technicist) {

        if (null != technicist) {
            //设置创建时间
            technicist.setModifyTime(DateTimeUtils.getNow());
            //执行更新
            int result =equipmentMapper.updateByPrimaryKeySelective(technicist);
            if (0 < result) {
                return result;
            }
        }
        return null;
    }
}
