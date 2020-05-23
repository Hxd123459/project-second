package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Dept;
import com.aaa.hjd.vo.DeptVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xxf
 */

public interface DeptMapper extends Mapper<Dept> {

    /**
     * @Author xxf
     * @Description
     * 查询所有部门并排序封装
     * @Date 22:19 2020/5/20
     * @Param [parentId]
     * @return java.util.List<com.xxf.model.Dept>
     * @throws
     **/
    List<Dept> selectList(Long parentId);

    /**
     * @Author xxf
     * @Description 批量删除
     * @Date 13:39 2020/5/23
     * @Param []
     * @return java.lang.Integer
     * @throws
     **/
    Integer deleteBatch(List<Dept> ids);

    /**
     * @Author xxf
     * @Description 搜索+查询
     * @Date 14:21 2020/5/23
     * @Param [deptVo]
     * @return java.util.List<com.aaa.hjd.model.Dept>
     * @throws
     **/
    List<Dept> selectForFields(DeptVo deptVo);
}