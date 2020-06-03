package com.aaa.hjd.mapper;

import com.aaa.hjd.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 特殊岗位人员信息
 */
public interface SpecialPostMapper extends Mapper<SpecialPost> {


    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户的id获取特殊岗位人员信息
     * @param [userId]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getSpecialPostByUserId(Long userId);
}