package com.aaa.hjd;

import com.aaa.hjd.base.ResultData;


import com.aaa.hjd.model.TMenu;

import com.aaa.hjd.model.TUser;
import com.aaa.hjd.vo.TokenVo;
import com.aaa.hjd.vo.UpdateUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/16 0016
 * Time: 13:11
 * Description:
 * fallbackFactory:就是来实现熔断的，在实际开发中，开发阶段不能去开启熔断
 * 因为一旦开启了熔断，整个异常都不会再抛出，不方便调bug
 * 实际开发必须注意的东西:
 * 无论是springcloud1.x还是2.x版本
 * 一旦使用feign来进行传递参数的时候，必须要注意两个点:
 * 1.如果是简单类型(8种基本类型，String)--->必须使用注解@RequestParam
 *   基本类型可以传多个，也就是说一个方法的参数中可以使用多@RequestParam
 * 2.如果传递包装类型(List, Map, Vo, Po),只能传递一个，而且必须要使用@RequestBody注解
 *   也就是说最终把这些参数值传递到provider项目的controller中，
 *   在这provider项目的controller中也必须使用,相同的注解，而且provider和api的方法必须要一模一样(copy是最方便的)
 */
@FeignClient(value = "system-interface")
public interface PubService {
    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody TUser user);

    /**
     * 查询所有的单位
     * @param tokenVo
     * @return
     */
    @ResponseBody
    @PostMapping("/getSurveyingUnits")
    ResultData selectAllSurveyingUnits(@RequestBody  TokenVo tokenVo);

    /**
     * 当用户需要进行登录时，引导前端跳转到登陆界面
     * @return
     */
    @RequestMapping("/turnLogin")
    TokenVo turnLogin();

    /**
     * 查询菜单信息
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/getAllMenus")
    ResultData getAllMenus(@RequestBody TMenu tMenu);

    /**
     * 新增菜单或者是按钮
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/addMenuOrButton")
     ResultData addMenuOrButton(@RequestBody TMenu tMenu);

    /**
     * 删除菜单或者是按钮根据id
     * @param ids 目标id
     * @return
     */
    @ResponseBody
    @PostMapping("/delMenuOrButton")
    ResultData delMenuOrButton(@RequestBody List<Object> ids);

    /**
     * 更新菜单或者是按钮
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/updateMenuOrButton")
    ResultData updateMenuOrButton(@RequestBody TMenu tMenu);

    /**
     * 通过id查询一条菜单或者是按钮信息
     * @param tMenu
     * @return
     */
    @ResponseBody
    @PostMapping("/selectMenuOrButtonById")
    ResultData selectMenuOrButtonById(@RequestBody TMenu tMenu);
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
    public ResultData getUserAll(@RequestBody HashMap<String, Integer> map);

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
    public ResultData getRoleAll();

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
    public ResultData getUserRoleByID(@RequestParam("id") Long id);

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
    public ResultData deleteUserByIDs (@RequestBody List<Object> ids);

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
    public ResultData updataUserByID (@RequestBody UpdateUserVo updataUserVo);

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
    public ResultData addUser(@RequestBody UpdateUserVo updataUserVo);

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
    public ResultData getDeptName();

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
    public ResultData getUserStatus();

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
    public ResultData getUserSsex();
}
