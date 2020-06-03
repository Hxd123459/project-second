package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Principal;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 单位负责人信息Mapper
 */
public interface PrincipalMapper extends Mapper<Principal> {

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位负责人信息
     * @param [userId]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    List<HashMap<String, Object>> getPrincipalByUserId(Long userId);

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 获取负责人附件信息
     * @param [principalId]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getPrincipalResource(Long principalId);
}