package com.aaa.hjd.controller;

import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.service.RedisService;
import com.aaa.hjd.service.SurveyingUnitService;
import com.aaa.hjd.vo.TokenVo;
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
 * Time: 13:52
 * Description:
 */
@Controller
public class SurveyingUnitController {
    @Autowired
    private SurveyingUnitService surveyingUnitService;
    @Autowired
    private RedisService redisService;
    @ResponseBody
    @PostMapping("/getSurveyingUnits")
    public ResultData selectAllSurveyingUnits(@RequestBody TokenVo tokenVo){
        ResultData resultData = surveyingUnitService.selectSurveyingUnitService(redisService);
        return resultData;
    }
}
