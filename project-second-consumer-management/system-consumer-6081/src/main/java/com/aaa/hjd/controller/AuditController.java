package com.aaa.hjd.controller;

import com.aaa.hjd.IDeptService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Audit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: xxf
 * @Time: Create in 2020/6/3  17:28
 * @Description:
 */
@RestController
@Api(value = "审核管理模块",tags = "审核管理接口")
public class AuditController {

    @Autowired
    private IDeptService iDeptService;

    /**
     * @Author xxf
     * @Description
     *      查询注册审核的单位信息
     *      分页+搜索
     * @Date 21:29 2020/5/26
     * @Param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectAuditForUnitInfo")
    @ApiOperation(value = "注册待审核单位信息",notes = "注册待审核查询功能")
    public ResultData selectAuditForUnitInfo(@RequestBody HashMap map){
        return iDeptService.selectAuditForUnitInfo(map);
    }

    /**
     * @Author xxf
     * @Description
     *      注册审核
     * @Date 9:43 2020/5/27
     * @Param [audit]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/toAuditForUnit")
    @ApiOperation(value = "注册审核",notes = "注册审核功能")
    public ResultData toAuditForUnit(@RequestBody Audit audit){
        return iDeptService.toAuditForUnit(audit);
    }

    /**
     * @Author xxf
     * @Description
     *      根据userId查询审核记录，并分页
     * @Date 10:17 2020/5/28
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectAuditByUserId")
    @ApiOperation(value = "查询审核记录",notes = "审核记录查询功能")
    public ResultData selectAuditByUserId(@RequestBody HashMap map){
        return iDeptService.selectAuditByUserId(map);
    }

    /**
     * @Author xxf
     * @Description
     *     待审核单位审核
     * @Date 11:08 2020/5/31
     * @Param [audit]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PutMapping("/insertAuditForUpdate")
    @ApiOperation(value = "待审核单位审核",notes = "待审核单位审核功能")
    public ResultData insertAudit(@RequestBody Audit audit){
        return iDeptService.insertAudit(audit);
    }

    /**
     * @Author xxf
     * @Description
     * 提交审核
     * @Date 17:30 2020/5/31
     * @Param [audit]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/submitAudit")
    @ApiOperation(value = "提交审核",notes ="提交审核功能" )
    public ResultData submitAudit(@RequestBody Audit audit){
        return iDeptService.submitAudit(audit);
    }
}
