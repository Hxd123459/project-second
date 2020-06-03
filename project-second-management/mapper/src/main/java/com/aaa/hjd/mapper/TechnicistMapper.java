package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Technicist;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 技术人员信息mapper
 */
public interface TechnicistMapper extends Mapper<Technicist> {

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询所有技术人员信息
     * @param [userId]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getTechnicistByUserId(Long userId);
}