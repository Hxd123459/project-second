package com.aaa.hjd.mapper.dao;

import com.aaa.hjd.mapper.entity.TMappingProject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 测绘项目信息(TMappingProject)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 23:06:25
 */
public interface TMappingProjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TMappingProject queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TMappingProject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tMappingProject 实例对象
     * @return 对象列表
     */
    List<TMappingProject> queryAll(TMappingProject tMappingProject);

    /**
     * 新增数据
     *
     * @param tMappingProject 实例对象
     * @return 影响行数
     */
    int insert(TMappingProject tMappingProject);

    /**
     * 修改数据
     *
     * @param tMappingProject 实例对象
     * @return 影响行数
     */
    int update(TMappingProject tMappingProject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}