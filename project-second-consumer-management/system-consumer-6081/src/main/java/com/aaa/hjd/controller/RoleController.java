package com.aaa.hjd.controller;

import com.aaa.hjd.IRoleService;
import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Role;
import com.aaa.hjd.model.RoleMenu;
import com.aaa.hjd.vo.RoleMenuSelecter;
import com.aaa.hjd.vo.RoleSelecter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * User: Aurora
 * Date: 2020/5/22
 * Time: 0:28
 */
@RestController
@Api(value = "角色信息",tags = "有关角色的操作接口")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @GetMapping("/selectAllRole")
    @ApiOperation(value = "查询全部角色",notes = "查询全部角色")
    public ResultData<Role> selectAllRole(){
        return iRoleService.selectAllRole();
    }

    @PutMapping("/insertRole")
    @ApiOperation(value = "添加角色",notes = "添加角色")
    public ResultData<Role> insertRole(@RequestBody Role role){
        return iRoleService.insertRole(role);
    }

    @DeleteMapping("/deleteRole")
    @ApiOperation(value = "删除角色",notes = "删除角色可以批量")
    public ResultData<Role> deleteRole(@RequestBody List<Object> list){
        return iRoleService.deleteRole(list);
    }

    @PostMapping("/updateRole")
    @ApiOperation(value = "更新角色和菜单",notes = "角色就该名字和备注就ok，菜单是list，不用写roleId了，直接添加menuid就OK")
    public ResultData updateRole(@RequestBody RoleMenuSelecter roleMenuSelecter){
        return iRoleService.updateRole(roleMenuSelecter);
    }

    @PostMapping("/selectRoleMenuById")
    @ApiOperation(value = "根据id查询角色信息",notes = "根据id查询角色信息和角色的菜单信息,只写个id就可以了")
    public ResultData selectRoleMenuById(@RequestBody Role role){
        return iRoleService.selectRoleMenuById(role);
    }

    @PostMapping("/selectByNameOrTime")
    @ApiOperation(value = "条件查询角色",notes = "角色名称 roleName，开始日期 startTime，结束日期 endTime")
    public ResultData selectByNameOrTime(@RequestBody RoleSelecter roleSelecter){
        return iRoleService.selectByNameOrTime(roleSelecter);
    }
}
