package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/21 0021
 * Time: 0:36
 * Description:
 */
@Controller
@Api(value = "菜单管理模块",tags = "菜单管理")
public class MenuController {
    @Autowired
    private PubService pubService;

    @ResponseBody
    @GetMapping("/getAllMenus")
    @ApiOperation(value = "获取所有父/子菜单",notes = "获取菜单信息")
    public ResultData getAllMenus(){
       return pubService.getAllMenus();
    }

    @ResponseBody
    @PostMapping("/addMenuOrButton")
    @ApiOperation(value = "新增菜单/按钮",notes = "填写菜单/按钮信息")
    public ResultData addMenuOrButton(@RequestBody TMenu tMenu){
        return pubService.addMenuOrButton(tMenu);
    }

    @ResponseBody
    @PostMapping("/delMenuOrButton")
    @ApiOperation(value = "删除菜单/按钮",notes = "填写删除菜单/按钮的id")
    public ResultData delMenuOrButton(@RequestBody List<Object> ids){
        return pubService.delMenuOrButton(ids);
    }

    @ResponseBody
    @PostMapping("/updateMenuOrButton")
    @ApiOperation(value = "更新菜单/按钮",notes = "填写新的菜单/按钮信息")
    public ResultData updateMenuOrButton(@RequestBody TMenu tMenu){
        return pubService.updateMenuOrButton(tMenu);
    }

    @ResponseBody
    @PostMapping("/selectMenuOrButtonById")
    @ApiOperation(value = "根基menuId查询菜单/按钮信息",notes = "填写新的菜单/按钮的menuId")
    public ResultData selectMenuOrButtonById(@RequestBody TMenu tMenu){
        return pubService.selectMenuOrButtonById(tMenu);
    }
}
