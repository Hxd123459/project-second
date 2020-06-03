package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.mapper.TechnicistMapper;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.utils.IdUtils;
import com.aaa.hjd.vo.PageNumAndSize;
import com.aaa.hjd.model.Technicist;
import com.aaa.hjd.utils.ObjectUtil;
import com.aaa.hjd.vo.TokenVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/26
 * 技术人员信息
 */
@Service
public class TechnicistService extends BaseService<Technicist> {

    @Autowired
    private TechnicistMapper technicistMapper;

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id获取技术人员信息
     * @param [session, pageNumAndSize]
     * @return com.github.pagehelper.PageInfo<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public PageInfo<HashMap<String, Object>> getTechnicistByUserId(HttpSession session, PageNumAndSize pageNumAndSize){
        //获取tokenVo
        TokenVo tokenVo = (TokenVo)session.getAttribute("tokenVo");
        //RedisKey就是用户的id
        String userId = tokenVo.getRedisKey();
        //转换类型
        Long id = ObjectUtil.transToLong(userId);
        //分页
        PageHelper.startPage(pageNumAndSize.getPageNum(), pageNumAndSize.getPageSize());
        //执行查询
        List<HashMap<String, Object>> list = technicistMapper.getTechnicistByUserId(id);
        if (0 < list.size()) {
            //判断成功返回
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
        return null;
    }

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id获取技术人员信息
     * @param [session, pageNumAndSize]
     * @return com.github.pagehelper.PageInfo<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public PageInfo<HashMap<String, Object>> getTechnicistByUserId(HashMap map){

        //获取相关用户的id，转换类型
        Long id = ObjectUtil.transToLong(map.get("userId"));
        //分页
        PageHelper.startPage(ObjectUtil.transToInt(map.get("pageNum")), ObjectUtil.transToInt(map.get("pageSize")));
        //根据用户id查询单位信息
        List<HashMap<String, Object>> list = technicistMapper.getTechnicistByUserId(id);
        if(0 < list.size()){
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
        return null;
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增技术人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer insertTechnicist(Technicist technicist) {

        if (null != technicist) {
            //设置创建时间
            technicist.setCreateTime(DateTimeUtils.getNow());
            //设置主键id
            technicist.setId(IdUtils.getLongID());
            //执行新增
            int result = technicistMapper.insert(technicist);
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
     * 修改技术人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer updateTechnicist(Technicist technicist) {

        if (null != technicist) {
            //设置创建时间
            technicist.setModifyTime(DateTimeUtils.getNow());
            //执行更新
            int result = technicistMapper.updateByPrimaryKeySelective(technicist);
            if (0 < result) {
                return result;
            }
        }
        return null;
    }
}
