package com.aaa.hjd.mapper;

import com.aaa.hjd.model.TMappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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

    /**
     * @Author xxf
     * @Description
     *      查询所有单位信息+搜索
     * @Date 11:37 2020/5/27
     * @Param [unitName]
     * @return java.util.List<com.aaa.hjd.model.TMappingUnit>
     * @throws
     **/
    List<TMappingUnit> selectUnitList(String unitName);

    /**
     * @Author xxf
     * @Description
     *      根据评分修改分数
     * @Date 9:43 2020/5/29
     * @Param [tMappingUnit]
     * @return java.lang.Integer
     * @throws
     **/
     Integer updateToScore(TMappingUnit tMappingUnit);

    /**
     * @Author xxf
     * @Description
     *      查询修改待审核的单位信息+搜索
     * @Date 10:45 2020/5/31
     * @Param [unitName]
     * @return java.util.List<com.aaa.hjd.model.TMappingUnit>
     * @throws
     **/
    List<TMappingUnit> selectAuditForUpdate(String unitName);

    /**
     * @Author xxf
     * @Description
     * 修改单位审核中的单位审核状态
     * @Date 16:48 2020/5/31
     * @Param [unit]
     * @return java.lang.Integer
     * @throws
     **/
    Integer updateAuditForUnit(TMappingUnit unit);
}
