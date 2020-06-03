package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Equipment;
import com.aaa.hjd.vo.PageNumAndSize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/28
 */
@RestController
@Api(value = "仪器设备",tags = "仪器设备相关操作")
public class EquipmentController {

    @Autowired
    private PubService pubService;

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取设备信息--分页
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getEquipment")
    @ApiOperation(value = "获取当前登录用户下的设备信息")
    public ResultData getEquipment(@RequestBody PageNumAndSize pageNumAndSize) {
        return pubService.getEquipment(pageNumAndSize);
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取设备信息--分页
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getEquipmentByUserId")
    @ApiOperation(value = "根据用户id获取设备信息")
    public ResultData getEquipmentByUserId(@RequestBody HashMap map) {
        System.out.println(map);
        return pubService.getEquipmentByUserId(map);
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 根据id数组删除设备信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deleteEquipmentByIDs")
    @ApiOperation(value = "根据id数组删除设备信息")
    public ResultData deleteEquipmentByIDs(@RequestBody List<Object> ids) {
        return pubService.deleteEquipmentByIDs(ids);
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增设备信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("insertEquipment")
    @ApiOperation(value = "新增设备信息")
    public ResultData insertEquipment(@RequestBody Equipment equipment) {
        return pubService.insertEquipment(equipment);
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 修改设备信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updateEquipment")
    @ApiOperation(value = "更新设备信息")
    public ResultData updateEquipment(@RequestBody Equipment equipment) {
        return pubService.updateEquipment(equipment);
    }
}
