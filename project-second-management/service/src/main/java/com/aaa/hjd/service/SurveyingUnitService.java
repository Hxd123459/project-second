package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.mapper.SurveyingUnitMapper;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.utils.JSONUtil;
import com.aaa.hjd.utils.ObjectUtil;
import com.aaa.hjd.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息
     * @param [userId]
     * @return com.aaa.hjd.model.TMappingUnit
     * @throws
     */
    public HashMap<String, Object> getMappingUnitByUserId(HttpSession session) {
        //获取tokenVo
        TokenVo tokenVo = (TokenVo)session.getAttribute("tokenVo");
        //RedisKey就是用户的id
        String userId = tokenVo.getRedisKey();
        //转换类型
        Long id = ObjectUtil.transToLong(userId);
        //根据用户id查询单位信息
        //根据用户的id查询单位详细信息
        HashMap<String, Object> map = surveyingUnitMapper.getMappingUnitByUserId(id);
        if (null != map) {
            //查询成功
            return map;
        }
        return null;
    }

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息
     * @param [userId]
     * @return com.aaa.hjd.model.TMappingUnit
     * @throws
     */
    public HashMap<String, Object> getMappingUnitByUserId(Long userId) {
        if (null != userId) {
            //根据用户id查询单位信息
            //根据用户的id查询单位详细信息
            HashMap<String, Object> muMap = surveyingUnitMapper.getMappingUnitByUserId(userId);
            if (null != muMap) {
                //查询成功
                return muMap;
            }
        }
        return null;
    }


    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 修改单位信息
     * @param [mappingUnit]
     * @return java.lang.Integer
     * @throws
     */
    public Integer updateMappingUnit(TMappingUnit mappingUnit){
        if (null != mappingUnit) {
            //设置userid为null防止修改到其他用户的单位，设置修改时间
            mappingUnit.setUserId(null).setModifyTime(DateTimeUtils.getNow());
            //执行修改
            Integer result = surveyingUnitMapper.updateByPrimaryKeySelective(mappingUnit);
            if (null!= result && 0 < result) {
                //返回受影响行
                return result;
            }
        }
        return null;
    }

}
