package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Role;
import com.aaa.hjd.model.RoleMenu;
import com.aaa.hjd.service.RoleMenuService;
import com.aaa.hjd.service.RoleService;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.vo.RoleMenuSelecter;
import com.aaa.hjd.vo.RoleSelecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Aurora
 * Date: 2020/5/21
 * Time: 0:45
 */
@RestController
public class RoleController extends CommonController<Role>{
    
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public BaseService<Role> getBaseService() {
        return roleService;
    }
    
    @GetMapping("/selectAllRole")
    public ResultData<Role> selectAllRole(){
        List<Role> roles = null;
        try {
            roles = roleService.queryList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(roles == null || roles.size() == 0){
            return selectRoleError();
        }
        return selectRoleSuccess(roles);
    }

    @PutMapping("/insertRole")
    public ResultData<Role> insertRole(@RequestBody Role role){
        Integer integer = null;
        role.setCreateTime(DateTimeUtils.getNow());
        try {
            integer = roleService.add(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(integer != null && integer != 0){
            return insertRoleSuccess();
        }
        return insertRoleFailed();
    }

    /**
     * 删除角色，并且删除角色的权限
     * @param list
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/deleteRole")
    public ResultData<Role> deleteRole(@RequestBody List<Object> list){
        Integer integer = null;
        try {
            integer = roleService.batchDeleteByPrimaryKey(list);
            //将要删除的角色id的id给roleMenu
            List<RoleMenu> roleMenus = new ArrayList();

            list.forEach((roleId) -> {
                roleMenus.add(new RoleMenu(Long.parseLong(roleId.toString()),null));
            } );

            //如果有需要删除角色在进行删除
            if(roleMenus != null && roleMenus.size()>0){
                //删除角色的菜单
                roleMenuService.batchDeleteRoleMenuByRoleId(roleMenus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(integer != null && integer > 0){
            return deleteRoleSuccess();
        }
        return deleteRoleError();
    }

    /**
     * 更新角色信息和角色的菜单
     * @param roleMenuSelecter
     * @return
     */
    @PostMapping("/updateRole")
    @Transactional(rollbackFor = Exception.class)
    public ResultData updateRole(@RequestBody RoleMenuSelecter roleMenuSelecter){
        Integer info = null;
        Role role = roleMenuSelecter.getRole();
        List<RoleMenu> roleMenus = roleMenuSelecter.getRoleMenus();
        try {
            //更新角色信息，一定要更新
            role.setModifyTime(DateTimeUtils.getNow());
            info = roleService.update(role);
            //如果角色信息没有更新，就说明有问题
            if(info == null || info != 1){
                return updateDataFailed();
            }

            //添加角色的菜单，应该先删除以前的菜单，在添加新的菜单
            RoleMenu rm = new RoleMenu();
            rm.setRoleId(role.getRoleId());
            //删除之前的,之前可以没有
            roleMenuService.deleteRoleMenuByRoleId(rm);

            //添加新的菜单，新的可以没有，如果没有就不要执行添加操作了
            if(roleMenus != null && roleMenus.size()>0){
                //给每个RoleMenu设置roleid
                roleMenus.forEach((temp) -> {temp.setRoleId(role.getRoleId());});
                System.out.println(roleMenus);
                roleMenuService.batchInsertRoleMenu(roleMenus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateDataSuccess();
    }

    /**
     * 根据id查询这个角色的信息和拥有的菜单
     * @return
     */
    @PostMapping("/selectRoleMenuById")
    public ResultData selectRoleMenuById(@RequestBody Role role){
        Map<String,Object> result = new HashMap(2);
        try {
            //查询角色的信息
            Role r = roleService.queryOne(role);
            //设置查询条件
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(role.getRoleId());
            //查询角色菜单
            List<RoleMenu> roleMenus = roleMenuService.queryList(roleMenu);
            result.put("roleInfo",r);
            result.put("menus",roleMenus);
            //如果查询成功
            if(r != null){
                return selectRoleSuccess(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectRoleError();
    }

    /**
     * 根据角色的信息，或者 角色的创建日期范围来进行查找
     * @param roleSelecter
     * @return
     */
    @PostMapping("/selectByNameOrTime")
    public ResultData selectByNameOrTime(@RequestBody RoleSelecter roleSelecter){
        List<Role> roles = roleService.selectByNameOrTime(roleSelecter);
        if(roles != null && roles.size()>0){
            return selectRoleSuccess(roles);
        }
        return selectRoleError();
    }
}
