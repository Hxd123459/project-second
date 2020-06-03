package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Equipment;
import com.aaa.hjd.model.Technicist;
import com.aaa.hjd.service.EquipmentService;
import com.aaa.hjd.vo.PageNumAndSize;
import com.github.pagehelper.PageInfo;
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
 * 设备信息控制层
 */
@RestController
public class EquipmentController extends CommonController<Equipment> {
    @Autowired
    private EquipmentService equipmentService;

    @Override
    public BaseService<Equipment> getBaseService() {
        return equipmentService;
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
    @PostMapping("/getEquipment")
    public ResultData getEquipment(@RequestBody PageNumAndSize pageNumAndSize) {
        //获取session
        HttpSession session = getSession();
        //执行查询
        PageInfo pageInfo = equipmentService.getEquipment(session, pageNumAndSize);
        if (null != pageInfo){
            //返回成功
            return selectSuccessZ(pageInfo);
        }
        return selectFailedZ();
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
    public ResultData getEquipmentByUserId(@RequestBody HashMap map) {

        //执行查询
        PageInfo pageInfo = equipmentService.getEquipmentByUserId(map);
        if (null != pageInfo){
            //返回成功
            return selectSuccessZ(pageInfo);
        }
        return selectFailedZ();
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
    public ResultData deleteEquipmentByIDs(@RequestBody List<Object> ids) {
        if (0 < ids.size()) {
            //当数不为null则执行删除
            return batchDelete(ids);
        }
        return delDataFailed();
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
    public ResultData insertEquipment(@RequestBody Equipment equipment) {

        if (null != equipment) {
            //新增
            Integer result = equipmentService.insertEquipment(equipment);
            if (0 < result) {
                return addDataSuccess();
            }
        }
        return addDataFailed();
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
    public ResultData updateEquipment(@RequestBody Equipment equipment) {

        if (null != equipment) {
            //修改
            Integer result = equipmentService.updateEquipment(equipment);
            if (0 < result) {
                return updateDataSuccess();
            }
        }
        return updateDataFailed();
    }
}
