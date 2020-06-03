package com.aaa.hjd.mapper;

import com.aaa.hjd.model.TMappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/19 0019
 * Time: 14:06
 * Description:T
 */
public interface SurveyingUnitMapper extends Mapper<TMappingUnit> {

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息
     * @param [userId]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    HashMap<String, Object> getMappingUnitByUserId(Long userId);
}
