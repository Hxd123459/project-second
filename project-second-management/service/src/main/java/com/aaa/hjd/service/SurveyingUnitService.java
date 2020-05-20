package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.mapper.SurveyingUnitMapper;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.utils.JSONUtil;
import com.aaa.hjd.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aaa.hjd.status.RedisFlag.RESULT_REDIS;
import static com.aaa.hjd.status.RedisFlag.UNIT_INFO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/19 0019
 * Time: 13:54
 * Description:
 */
@Service
public class SurveyingUnitService extends BaseService<TMappingUnit> {
    @Autowired
    private SurveyingUnitMapper surveyingUnitMapper;
    public ResultData selectSurveyingUnitService(RedisService redisService){
        ResultData resultData = new ResultData();

        //先去redis中查询
        String s = redisService.get(UNIT_INFO);
        if (null!=s&&"".equals(s)) {
            //说明redis中有数据
            resultData.setMsg("查询成功");
            resultData.setCode("10011");
            resultData.setData(JSONUtil.toList(s,TMappingUnit.class));
        }else {
            //说明redis中没有数据
            //去数据库中查询
            List<TMappingUnit> list = surveyingUnitMapper.selectAll();
            String listToString = JSONUtil.toJsonString(list);
            if (null!=list&&list.size()>0){
                resultData.setMsg("查询成功");
                resultData.setCode("10011");
                resultData.setData(list);
                //将数据放入到redis中
                if (!RESULT_REDIS.equals(redisService.set(UNIT_INFO,listToString))) {
                    //说明 redis存放失败
                    resultData.setMsg("查询成功,redis存放失败！");
                }
            }else {
                resultData.setMsg("无数据");
                resultData.setCode("20006");
            }
        }
        return resultData;
    }
}
