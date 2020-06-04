package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.service.RedisService;
import com.aaa.hjd.service.SurveyingUnitService;
import com.aaa.hjd.vo.TokenVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/19 0019
 * Time: 13:52
 * Description:
 */
@RestController
public class SurveyingUnitController extends CommonController<TMappingUnit> {
    @Override
    public BaseService<TMappingUnit> getBaseService() {
        return surveyingUnitService;
    }
    @Autowired
    private SurveyingUnitService surveyingUnitService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/getSurveyingUnits")
    public ResultData selectAllSurveyingUnits(@RequestBody TokenVo tokenVo){
        ResultData resultData = surveyingUnitService.selectSurveyingUnitService(redisService);
        return resultData;
    }


}
