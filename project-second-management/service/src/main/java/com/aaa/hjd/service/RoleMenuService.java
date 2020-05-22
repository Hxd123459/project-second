package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.RoleMenuMapper;
import com.aaa.hjd.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Aurora
 * Date: 2020/5/21
 * Time: 20:16
 */
@Service
public class RoleMenuService extends BaseService<RoleMenu> {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public Integer deleteRoleMenuByRoleId(RoleMenu roleMenu) throws Exception{
        return roleMenuMapper.deleteRoleMenuByRoleId(roleMenu);
    }

    public Integer batchInsertRoleMenu(List<RoleMenu> list) throws Exception{
        return roleMenuMapper.batchInsertRoleMenu(list);
    }

    public Integer batchDeleteRoleMenuByRoleId(List<RoleMenu> list){
        return roleMenuMapper.batchDeleteRoleMenuByRoleId(list);
    }
}
