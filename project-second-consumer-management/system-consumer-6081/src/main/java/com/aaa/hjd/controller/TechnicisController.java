package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Technicist;
import com.aaa.hjd.vo.PageNumAndSize;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/6/2
 */
@RestController
@Api(value = "技术人员信息相关操作",tags = "技术人员信息相关操作")
public class TechnicisController {

    @Autowired
    private PubService pubService;

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取技术人员信息，id需要根据当前登录用户获取
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getTechnicist")
    @ApiOperation(value = "获取当前用户下技术人员信息")
    public ResultData getTechnicist(@RequestBody PageNumAndSize pageNumAndSize){
        return pubService.getTechnicist(pageNumAndSize);
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id获取技术人员信息
     * @param [pageNumAndSize]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getTechnicistByUserId")
    @ApiOperation(value = "根据用户id获取技术人员信息")
    public ResultData getTechnicistByUserId(@RequestBody HashMap map) {
        return pubService.getTechnicistByUserId(map);
    }
    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 根据id数组删除技术人员信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deleteTechnicistByIDs")
    @ApiOperation(value = "删除技术人员信息id数组")
    public ResultData deleteTechnicistByIDs(@RequestBody List<Object> ids) {
        return pubService.deleteTechnicistByIDs(ids);
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 新增技术人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("insertTechnicist")
    @ApiOperation(value = "新增技术人员信息")
    public ResultData insertTechnicist(@RequestBody Technicist technicist) {
        return pubService.insertTechnicist(technicist);
    }

    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 修改技术人员信息
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("updateTechnicist")
    @ApiOperation(value = "更新技术人员信息")
    public ResultData updateTechnicist(@RequestBody Technicist technicist) {
        return pubService.updateTechnicist(technicist);
    }
}
