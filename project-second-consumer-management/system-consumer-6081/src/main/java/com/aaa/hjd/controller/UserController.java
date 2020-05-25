package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.vo.UpdateUserVo;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/23
 */
@RestController
@Api(value = "用户管理",tags = "用户管理接口")
public class UserController {
    @Autowired
    private PubService pubService;

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有用户信息带分页
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @PostMapping("/getUserAll")
    @ApiOperation(value = "查询用户所有信息")
    public ResultData getUserAll(@RequestBody @ApiParam("pageNum和pageSize") HashMap<String, Integer> map){
      return pubService.getUserAll(map);
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有角色
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("/getRoleAll")
    @ApiOperation(value = "获取所有角色")
    public ResultData getRoleAll() {
        return pubService.getRoleAll();
    }

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据id获取用户的所有角色
     * @param [id]
     * @return java.util.List<java.lang.Long>
     * @throws
     */
    @GetMapping("/getUserRoleByID")
    @ApiOperation(value = "根据id获取用户的角色")
    public ResultData getUserRoleByID(@RequestParam("id") Long id){
        System.out.println(id);
       return pubService.getUserRoleByID(id);
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据ids删除所有用户
     * @param []
     * @return java.lang.Integer
     * @throws
     */
    @DeleteMapping("/deleteUserByIDs")
    @ApiOperation(value = "批量删除")
    public ResultData deleteUserByIDs (@RequestBody List<Object> ids){
        return pubService.deleteUserByIDs(ids);
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据用户id修改用户信息
     * @param []
     * @return java.lang.Integer
     * @throws
     */
    @PostMapping("/updataUserByID")
    @ApiOperation(value = "更新用户信息信息")
    public ResultData updataUserByID (@RequestBody UpdateUserVo updateUserVo) {
        System.out.println(updateUserVo);
        return pubService.updataUserByID(updateUserVo);
    }

    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 新增用户
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PutMapping("/addUser")
    @ApiOperation(value = "新增用户")
    public ResultData addUser(@RequestBody UpdateUserVo updataUserVo){
       return pubService.addUser(updataUserVo);
    }
    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 获取部门层级列表
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @GetMapping("/getDeptName")
    @ApiOperation(value = "获取部门列表")
    public ResultData getDeptName() {
        return pubService.getDeptName();
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表状态值
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("getUserStatus")
    @ApiOperation(value = "获取用户状态字典表")
    public ResultData getUserStatus(){
      return pubService.getUserStatus();
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表性别
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("getUserSsex")
    @ApiOperation(value = "获取用户性别字典表")
    public ResultData getUserSsex(){
       return pubService.getUserSsex();
    }


}
