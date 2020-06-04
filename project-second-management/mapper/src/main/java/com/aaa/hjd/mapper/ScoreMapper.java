package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Score;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xxf
 */
public interface ScoreMapper extends Mapper<Score> {


    /**根据单位id查询评分记录
     * @param unitId
     * @return
     */
    List<Score> selectScoreByUnitId(Long unitId);
}