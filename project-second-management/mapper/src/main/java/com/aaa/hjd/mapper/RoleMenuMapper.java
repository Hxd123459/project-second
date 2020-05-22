package com.aaa.hjd.mapper;

import com.aaa.hjd.model.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {

    Integer deleteRoleMenuByRoleId(RoleMenu roleMenu);

    Integer batchInsertRoleMenu(List<RoleMenu> list);

    Integer batchDeleteRoleMenuByRoleId(List<RoleMenu> list);
}