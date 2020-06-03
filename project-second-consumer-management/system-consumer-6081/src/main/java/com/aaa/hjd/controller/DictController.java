package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TDict;
import com.aaa.hjd.vo.DictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/4 0004
 * Time: 1:10
 * Description:
 */
@RestController
@Api(value = "字典管理模块",tags = "字典管理操作")
public class DictController {
    @Autowired
    private PubService pubService;


    @PostMapping("/selectDictByPage")
    @ApiOperation(value = "查询字典信息（带分页，带条件查询）",notes = "填写分页信息或者是条件信息")
    ResultData selectDictByPage(@RequestBody DictVo dictVo){
        return pubService.selectDictByPage(dictVo);
    }
    @PostMapping("/selectDictById")
    @ApiOperation(value = "根据id查询字典信息",notes = "用户修改时")
    ResultData selectDictById(@RequestBody TDict tDict){
        return pubService.selectDictById(tDict);
    }
    @PostMapping("/updateDictById")
    @ApiOperation(value = "根据id更新字典信息",notes = "填写要更新的信息")
    ResultData updateDictById(@RequestBody TDict dict){
        return pubService.updateDictById(dict);
    }
    @PostMapping("/addDict")
    @ApiOperation(value = "添加字典信息",notes = "填写字典信息")
    ResultData addDict(@RequestBody TDict tDict){
        return pubService.addDict(tDict);
    }
    @PostMapping("/deleteBatchByIds")
    @ApiOperation(value = "通过id批量删除字典信息",notes = "填写字典id")
    ResultData deleteBatchByIds(@RequestBody List<Object> ids){
        return pubService.deleteBatchByIds(ids);
    }
}
