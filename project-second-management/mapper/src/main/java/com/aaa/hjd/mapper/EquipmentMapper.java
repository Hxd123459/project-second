package com.aaa.hjd.mapper;

import com.aaa.hjd.model.Equipment;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
/**
 * 仪器设备信息mapper
 * @author 19435
 */
public interface EquipmentMapper extends Mapper<Equipment> {

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取仪器设备信息
     * @param [userId]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    List<HashMap<String, Object>> getEquipmentByUserId(Long userId);
}