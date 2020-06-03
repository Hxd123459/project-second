package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.SpecialPostMapper;
import com.aaa.hjd.model.SpecialPost;
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
 * 特殊岗位人员信息
 */
@Service
public class SpecialPostService extends BaseService<SpecialPost> {

    @Autowired
    private SpecialPostMapper specialPostMapper;

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户的id获取特殊岗位人员信息
     * @param [session, pageNumAndSize]
     * @return com.github.pagehelper.PageInfo<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public PageInfo<HashMap<String, Object>> getSpecialPostByUserId(HttpSession session, PageNumAndSize pageNumAndSize) {
        //获取tokenVo
        TokenVo tokenVo = (TokenVo)session.getAttribute("tokenVo");
        //RedisKey就是用户的id
        String userId = tokenVo.getRedisKey();
        //转换类型
        Long id = ObjectUtil.transToLong(userId);
        //分页
        PageHelper.startPage(pageNumAndSize.getPageNum(), pageNumAndSize.getPageSize());
        //执行查询
        List<HashMap<String, Object>> list = specialPostMapper.getSpecialPostByUserId(id);
        if (0 < list.size()) {
            //判断成功返回
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
        return null;
    }


    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户的id获取特殊岗位人员信息
     * @param [session, pageNumAndSize]
     * @return com.github.pagehelper.PageInfo<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    public PageInfo<HashMap<String, Object>> getSpecialPostByUserId(HashMap map) {

        //获取相关用户的id，转换类型
        Long id = ObjectUtil.transToLong(map.get("userId"));
        //分页
        PageHelper.startPage(ObjectUtil.transToInt(map.get("pageNum")), ObjectUtil.transToInt(map.get("pageSize")));
        //执行查询
        List<HashMap<String, Object>> list = specialPostMapper.getSpecialPostByUserId(id);
        if (0 < list.size()) {
            //判断成功返回
            PageInfo<HashMap<String, Object>> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
        return null;
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增特殊人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer insertSpecialPost(SpecialPost specialPost) {

        if (null != specialPost) {
            //设置创建时间
            specialPost.setCreateTime(DateTimeUtils.getNow());
            //设置主键id
            specialPost.setId(IdUtils.getLongID());
            //执行新增
            int result = specialPostMapper.insert(specialPost);
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
     * 修改特殊人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    public Integer updateSpecialPost(SpecialPost specialPost) {

        if (null != specialPost) {
            //设置创建时间
            specialPost.setModifyTime(DateTimeUtils.getNow());
            //执行更新
            int result = specialPostMapper.updateByPrimaryKeySelective(specialPost);
            if (0 < result) {
                return result;
            }
        }
        return null;
    }
}
