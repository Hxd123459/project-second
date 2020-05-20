package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/19 0019
 * Time: 11:32
 * Description:
 * 测绘单位相关的controller
 */
@Controller
@Api(value = "查询所有单位信息",tags = "查询单位信息")
public class SurveyingUnitController {
    @Autowired
    private PubService pubService;
    @ResponseBody
    @PostMapping("/getSurveyingUnits")
    @ApiOperation(value = "查询所有的单位信息",notes = "查询所有单位功能")
    public ResultData selectAllSurveyingUnits(@RequestBody @ApiParam("登陆验证的token") TokenVo tokenVo){
        ResultData resultData = pubService.selectAllSurveyingUnits(tokenVo);
        return resultData;
    }
}
