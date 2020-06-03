package com.aaa.hjd.controller;

import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Principal;
import com.aaa.hjd.vo.PageNumAndSize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/6/2
 */
@Api(value = "单位负责人相关操作",tags = "单位负责人相关操作")
@RestController
public class PrincipalController {

    @Autowired
    private PubService pubService;
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
    @ApiOperation(value = "获取当前登录用户下的单位负责人信息")
    public ResultData getPrincipalByUserId(@RequestBody PageNumAndSize pageNumAndSize) {
        return pubService.getPrincipal(pageNumAndSize);
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
    @ApiOperation(value = "根据用户id获取负责人信息")
    @PostMapping("/getPrincipalByUserId")
    public ResultData getPrincipalByUserId(@RequestBody HashMap map) {
       return pubService.getPrincipalByUserId(map);
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
    @ApiOperation(value = "新增负责人信息")
    @PostMapping("addPrincipal")
    public ResultData addPrincipal (@RequestBody Principal principal) {
        return pubService.addPrincipal(principal);
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
    @ApiOperation(value = "修改负责人信息")
    public ResultData updatePrincipal(@RequestBody Principal principal) {
        return pubService.updatePrincipal(principal);
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
    @ApiOperation(value = "删除负责人信息")
    @DeleteMapping("/deletePrincipals")
    public ResultData deletePrincipals(@RequestBody List<Object> ids) {
        return pubService.deletePrincipals(ids);
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
    @ApiOperation(value = "查询单位附件信息")
    @PostMapping("/getPrincipalResource")
    public ResultData getPrincipalResource(@RequestParam("principalId") Long principalId) {
        return pubService.getPrincipalResource(principalId);
    }

}
