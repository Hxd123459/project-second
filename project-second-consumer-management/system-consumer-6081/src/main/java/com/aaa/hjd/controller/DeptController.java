package com.aaa.hjd.controller;

import com.aaa.hjd.IDeptService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Dept;
import com.aaa.hjd.vo.DeptVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/23  16:31
 * @Description:
 */
@RestController
@Api(value = "部门管理模块",tags = "部门管理接口")
public class DeptController {

    @Autowired
    private IDeptService pubService;

    @PostMapping("/insertDept")
    @ApiOperation(value = "新增部门",notes = "新增部门")
    public ResultData insertDept(@RequestBody Dept dept){
        return pubService.insertDept(dept);
    }

    @PutMapping("/updateDept")
    @ApiOperation(value = "更新部门信息",notes = "更新部门信息")
    public ResultData updateDept(@RequestBody Dept dept){
        return pubService.updateDept(dept);
    }

    @DeleteMapping("/deleteDept")
    @ApiOperation(value = "删除部门信息",notes = "删除部门信息")
    public ResultData deleteDept(@RequestBody Dept dept){
        return pubService.deleteDept(dept);
    }

    @DeleteMapping("/deleteDeptList")
    @ApiOperation(value = "批量删除部门信息",notes = "批量删除部门信息")
    public ResultData deleteList(@RequestBody List<Dept> ids) {
        return pubService.deleteList(ids);
    }

    @GetMapping("/selectDeptOne")
    @ApiOperation(value = "根据id查询部门信息",notes = "根据id查询部门信息")
    public ResultData selectOne(@RequestParam("deptId") Long deptId){
        return pubService.selectOne(deptId);
    }


    @PostMapping("/selectDeptForFields")
    @ApiOperation(value = "查询+搜索",notes = "查询+搜索")
    public ResultData selectForFields(@RequestBody DeptVo deptVo){
        return pubService.selectForFields(deptVo);
    }
}
