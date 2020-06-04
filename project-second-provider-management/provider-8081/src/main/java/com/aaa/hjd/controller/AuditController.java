package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseController;
import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Audit;
import com.aaa.hjd.service.AuditService;
import com.aaa.hjd.utils.IdUtils;
import com.aaa.hjd.utils.TimeUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/26  20:58
 * @Description:
 */
@RestController
public class AuditController extends CommonController<Audit> {
    @Override
    public BaseService<Audit> getBaseService() {
        return auditService;
    }
    @Autowired
    private AuditService auditService;

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
    public ResultData selectAuditForUnitInfo(@RequestBody HashMap map) {
        PageInfo pageInfo = auditService.selectAuditForUnitInfo(map);
        if (pageInfo == null || pageInfo.getList().size() <= 0 ||pageInfo.getList() ==null) {
            return selectFailed();
        }
        return selectSuccess(pageInfo);
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
    public ResultData toAuditForUnit(@RequestBody Audit audit){
        boolean b = auditService.toAuditForUnit(audit);
        if (b) {
            return updateDataSuccess("注册审核成功");
        }
        return updateDataFailed("注册审核失败");
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
    public ResultData selectAuditByUserId(@RequestBody HashMap map) {
        PageInfo<Audit> auditPageInfo = auditService.selectAuditByUserId(map);
        if (null == auditPageInfo){
            return super.selectFailedZ("暂无数据");
        }
        return super.selectSuccess(auditPageInfo);
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
    public ResultData insertAudit(@RequestBody Audit audit) {
        boolean b = auditService.insertAudit(audit);
        if (b) {
            return super.addDataSuccess("修改审核成功");
        }
        return super.addDataFailed("修改审核失败");
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
    public ResultData submitAudit(@RequestBody Audit audit) {
        boolean b = auditService.submitAudit(audit);
        if (b) {
            return super.addDataSuccess("提交审核成功");
        }
        return super.addDataFailed("提交审核失败");
    }
}
