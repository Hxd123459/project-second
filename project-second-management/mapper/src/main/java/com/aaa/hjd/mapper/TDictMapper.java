package com.aaa.hjd.mapper;

import com.aaa.hjd.model.TDict;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * (TDict)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-03 23:48:07
 */
public interface TDictMapper extends Mapper<TDict> {
    /**
     * 根据id批量删除字典数据
     * @param ids
     * @return
     */
   Integer deleteBatchById(List<Object> ids);
}