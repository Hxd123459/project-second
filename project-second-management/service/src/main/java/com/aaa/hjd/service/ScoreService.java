package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.ScoreMapper;
import com.aaa.hjd.mapper.SurveyingUnitMapper;
import com.aaa.hjd.model.Resource;
import com.aaa.hjd.model.Score;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.aaa.hjd.status.FtpIpProperties.*;
import static com.aaa.hjd.status.FtpIpProperties.FTP_IP;
import static com.aaa.hjd.status.TimeProperties.TIME_TYPE;
import static com.aaa.hjd.status.TimeProperties.TIME_TYPE02;

/**
 * @author: xxf
 * @Time: Create in 2020/5/28  10:52
 * @Description:
 */
@Service
public class ScoreService extends BaseService<Score> {

    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private SurveyingUnitMapper surveyingUnitMapper;


    /**根据单位id查询评分记录
     * @param unitId
     * @return
     */
    public PageInfo<Score> selectScoreByUnitId(HashMap map){
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Long unitId = (Long) map.get("unitId");
        PageHelper.startPage(pageNum,pageSize);
        List<Score> scores = scoreMapper.selectScoreByUnitId(unitId);
        if (scores.size() > 0 ){
            return new PageInfo(scores);
        }
        return null;
    }

    /**
     * @Author xxf
     * @Description
     *      调正评分，生成评分记录
     * @Date 9:22 2020/5/29
     * @Param []
     * @return boolean
     * @throws
     **/
    @Transactional(rollbackFor = Exception.class)
    public boolean insertToScore(Score score){
        //生成id
        Long longID = IdUtils.getLongID();
         //获取创造时间
        String createTime = TimeUtils.getNowTimeYMDHMS();
        score.setId(longID).setCreateTime(createTime);
        try {
            //添加评分记录
            Integer add = super.add(score);
            //获取传递过来的单位id
            Long unitId = score.getUnitId();
            //是否加分
            Integer scorePlus = score.getScorePlus();
            if (scorePlus == null || scorePlus <= 0){
                //是否减分
                Integer scoreSubtract = score.getScoreSubtract();
                if (scoreSubtract == null || scoreSubtract <= 0){
                    if (add > 0) {
                        return true;
                    }
                }
                if (scoreSubtract > 0) {
                    //减分
                    //将数据存入TMappingUnit
                    TMappingUnit tMappingUnit = new TMappingUnit();
                    tMappingUnit.setScore(scoreSubtract*(-1)).setId(unitId);
                    Integer integer = surveyingUnitMapper.updateToScore(tMappingUnit);
                    if (integer > 0 && add > 0) {
                        return true;
                    }
                }
            }
            if (scorePlus > 0){
                //加分
                //将数据存入TMappingUnit
                TMappingUnit tMappingUnit = new TMappingUnit();
                tMappingUnit.setScore(scorePlus).setId(unitId);
                Integer integer = surveyingUnitMapper.updateToScore(tMappingUnit);
                if (integer > 0 && add > 0){
                    return true;
                }
            }
            if (add > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * @Author xxf
     * @Description
     * 评分附件上传,并称成资源信息
     * @Date 10:56 2020/6/4
     * @Param [file, unitId, resourceService]
     * @return java.lang.Boolean
     * @throws
     **/
    @Transactional(rollbackFor = Exception.class)
    public  Boolean beforeToDo(MultipartFile file, Long unitId, ResourceService resourceService) throws Exception {
        String filePath= DateUtils.formatDate(new Date(),TIME_TYPE02);
        String suffix="."+file.getOriginalFilename().split("\\.")[1];
        String newFileName= FileNameUtils.getFileName()+suffix;
        String createTimeAndModifyTime=DateUtils.formatDate(new Date(),TIME_TYPE);
        //文件上传
        boolean uploadFileOfResult = FtpUtils.UploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newFileName, file.getInputStream());
        //将数据放到t_resource中
        Resource resource = new Resource();
        resource.setId(new IdWorker().nextId())
                .setName(file.getOriginalFilename())
                .setSize(file.getSize())
                .setPath(FTP_IP+"/"+filePath+"/"+newFileName)
                .setExtName(suffix)
                .setRefBizType("附件")
                .setRefBizId(unitId)
                .setCreateTime(createTimeAndModifyTime)
                .setModifyTime(createTimeAndModifyTime);
        Integer add = resourceService.add(resource);
        if (add == 1 && uploadFileOfResult) {
            return true;
        }
        return false;
    }
}
