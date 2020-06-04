package com.aaa.hjd.controller;

import com.aaa.hjd.IDeptService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Score;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author: xxf
 * @Time: Create in 2020/6/3  17:41
 * @Description:
 */
@RestController
@ApiOperation(value = "评分模块管理" ,tags ="评分模块管理接口")
public class ScoreController {
    @Autowired
    private IDeptService iDeptService;

    /**
     * @Author xxf
     * @Description
     *  通过单位id查询评分记录，并分页
     * @Date 17:13 2020/5/28
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectScoreByUnitId")
    @ApiOperation(value = "查询评分记录", notes = "评分记录查询功能")
    public ResultData selectScoreByUnitId(@RequestBody HashMap map){
        return iDeptService.selectScoreByUnitId(map);
    }

    /**
     * @Author xxf
     * @Description
     * 添加评分记录，并修改单位评分值
     * @Date 10:10 2020/5/29
     * @Param [score]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/

    @ApiOperation(value = "添加评分记录，并修改单位评分值", notes = "添加评分记录，并修改单位评分值")
    @PostMapping(value = "/insertToScore",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData insertToScore(@RequestPart(value = "file",required = false) MultipartFile file,
                             @RequestParam(value = "score") Integer score,
                             @RequestParam(value = "unitId")Long unitId,
                             @RequestParam(value = "scorePlus",required = false)Integer scorePlus,
                             @RequestParam(value = "reason")String reason,
                             @RequestParam(value = "scoreSubtract",required = false)Integer scoreSubtract){

                return iDeptService.insertToScore(file, score, unitId, scorePlus, reason, scoreSubtract);
    }


}
