package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Audit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author xxf
 */
public interface AuditMapper extends Mapper<Audit> {

    /**
     * @Author xxf
     * @Description
     *      多表联查t_user t_mapping_unit
     *      查询注册审核的单位信息,即在user表中status为锁定的单位信息
     * @Date 20:50 2020/5/26
     * @Param []
     * @return java.util.List<java.util.HashMap>
     * @throws
     **/
    List<HashMap> selectAuditForUnitInfo(String unitName);

    /**
     * @Author xxf
     * @Description
     *      注册审核
     * @Date 21:55 2020/5/26
     * @Param [map]
     * @return java.lang.Integer
     * @throws
     **/
    Integer toAuditForUnit(Audit audit);


    /** 根据userId查询审核记录
     * @param userId
     * @return
     */
    List<Audit> selectAuditByUserId(Long userId);


}