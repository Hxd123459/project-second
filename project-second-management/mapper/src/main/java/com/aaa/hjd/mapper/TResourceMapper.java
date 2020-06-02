package com.aaa.hjd.mapper.dao;

import com.aaa.hjd.mapper.entity.TResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 附件表(TResource)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 21:09:28
 */
public interface TResourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TResource queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TResource> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tResource 实例对象
     * @return 对象列表
     */
    List<TResource> queryAll(TResource tResource);

    /**
     * 新增数据
     *
     * @param tResource 实例对象
     * @return 影响行数
     */
    int insert(TResource tResource);

    /**
     * 修改数据
     *
     * @param tResource 实例对象
     * @return 影响行数
     */
    int update(TResource tResource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}