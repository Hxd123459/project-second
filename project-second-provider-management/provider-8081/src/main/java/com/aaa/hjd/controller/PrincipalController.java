package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Principal;
import com.aaa.hjd.service.PrincipalService;
import com.aaa.hjd.vo.PageNumAndSize;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/26
 * 单位负责人信息
 */
@RestController

public class PrincipalController extends CommonController<Principal> {
    @Autowired
    private PrincipalService principalService;

    @Override
    public BaseService<Principal> getBaseService() {
        return principalService;
    }

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id获取单位负责人信息
     * 需要自己获取到当前登录用户的id
     * @param [session]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    @PostMapping("/getPrincipal")
    public ResultData getPrincipal(@RequestBody PageNumAndSize pageNumAndSize) {
        //获取session
        HttpSession session = getSession();
        //执行查询
        PageInfo pageInfo = principalService.getPrincipalByUserId(session, pageNumAndSize);
        if (null != pageInfo){
            //返回成功
            return selectSuccessZ(pageInfo);
        }
        return selectFailedZ();
    }

    /**
     * @date:  2020/5/26
     * @author: 秀仔
     * @Description
     * 根据用户id获取单位负责人信息
     * 需要自己获取到当前登录用户的id
     * @param [session]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws
     */
    @PostMapping("/getPrincipalByUserId")
    public ResultData getPrincipalByUserId(@RequestBody HashMap map) {
        //执行查询
        PageInfo pageInfo = principalService.getPrincipalByUserId(map);
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
     * 新增单位负责人信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("addPrincipal")
    public ResultData addPrincipal (@RequestBody Principal principal) {
        if (null!= principal) {
            Integer insert = principalService.addPrincipal(principal);
            if (0 < insert) {
                //新增数据成功
                return addDataSuccess();
            }
        }
        return addDataFailed();
    }

    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 修改负责人信息
     * @param [principal]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal) {
        if (null != principal){
            //执行更新
            Integer integer = principalService.updatePrincipal(principal);
            if (null != integer && 0 < integer) {
                //返回成功
                return updateDataSuccess();
            }
        }
        //返回失败
        return updateDataFailed();
    }

    /**
     * @date:  2020/5/29
     * @author: 秀仔
     * @Description
     * 删除负责人信息
     * @param [principal]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @DeleteMapping("/deletePrincipals")
    public ResultData deletePrincipals(@RequestBody List<Object> ids) {
        if (0 < ids.size()) {
            //删除数据,并返回
            return batchDelete(ids);
        }
        //返回失败
        return delDataFailed();
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 查询单位负责人附件信息
     * @param
     * @return
     * @throws
     */
    @PostMapping("/getPrincipalResource")
    public ResultData getPrincipalResource(@RequestParam("principalId") Long principalId) {
        System.out.println(principalId);

        if (null != principalId) {
            //查询附件信息
            List<HashMap<String, Object>> list = principalService.getPrincipalResource(principalId);
            if (0 < list.size()) {
                return selectSuccess(list);
            }
        }
        return selectFailed();
    }
}
