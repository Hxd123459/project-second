package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Score;
import com.aaa.hjd.service.ResourceService;
import com.aaa.hjd.service.ScoreService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author: xxf
 * @Time: Create in 2020/5/28  17:09
 * @Description:
 */
@RestController
public class ScoreController extends CommonController<Score> {
    @Override
    public BaseService<Score> getBaseService() {
        return scoreService;
    }
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ResourceService resourceService;

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
    public ResultData selectScoreByUnitId(@RequestBody HashMap map) {
        PageInfo<Score> scorePageInfo = scoreService.selectScoreByUnitId(map);
        if (null == scorePageInfo) {
            return super.selectFailedZ("暂无数据");
        }
        return selectRoleSuccess(scorePageInfo);
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
//    @PostMapping("/insertToScore")
//    public ResultData insertToScore(@RequestBody Score score) {
//        boolean b = scoreService.insertToScore(score);
//        if (b) {
//            return super.updateDataSuccess("修改评分成功");
//        }
//        return super.updateDataFailed("评分失败");
//    }


        @PostMapping(value = "/insertToScore",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
        @Transactional(rollbackFor = Exception.class)
    public ResultData insertToScore(@RequestPart(value = "file",required = false) MultipartFile file,
                                    @RequestParam(value = "score") Integer score,
                                    @RequestParam(value = "unitId")Long unitId,
                                    @RequestParam(value = "scorePlus" ,required = false)Integer scorePlus,
                                    @RequestParam(value = "reason")String reason,
                                    @RequestParam(value = "scoreSubtract" ,required = false)Integer scoreSubtract) {

            Score addScore = new Score();
            addScore.setUnitId(unitId).setScore(score).setReason(reason).setScorePlus(scorePlus).setScoreSubtract(scoreSubtract);
            try {
                //生成评分记录表
                boolean b = scoreService.insertToScore(addScore);
                //上传文件
                if (file == null) {
                    if (b) {
                        return super.addDataSuccess();
                    }
                }
                Boolean aBoolean = scoreService.beforeToDo(file, unitId, resourceService);
                if (b && aBoolean) {
                    return super.addDataSuccess();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.addDataFailed("评分失败");
    }
}
