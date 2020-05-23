package com.aaa.hjd.mapper;


import com.aaa.hjd.model.TMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (TMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-20 23:27:05
 */
public interface TMenuMapper extends Mapper<TMenu> {

    /**
     * 批量删除菜单或者按钮
     * @param ids
     * @return
     */
     Integer batchDelMenuOrButton(List<Object> ids);

    /**
     * 根据parentId来查询菜单或者按钮信息
     * @param tMenu
     * @return
     */
     List<TMenu> selectMenuByParenId(TMenu tMenu);

}