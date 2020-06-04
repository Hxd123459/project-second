package com.aaa.hjd.controller;

import com.aaa.hjd.IDeptService;
import com.aaa.hjd.base.ResultData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: xxf
 * @Time: Create in 2020/6/3  20:54
 * @Description:
 */
@RestController
@ApiOperation(value = "项目管理模块",tags = "项目管理模块接口")
public class ProjectController {

    @Autowired
    private IDeptService iDeptService;

    /**
     * @Author xxf
     * @Description
     * 根据单位表的user_id查询项目信息+搜索+分页
     * @Date 16:18 2020/5/29
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectProjectByUserId")
    @ApiOperation(value = "根据单位表的user_id查询项目信息+搜索+分页",notes = "根据单位表的user_id查询项目信息+搜索+分页")
    public ResultData selectByUserId(@RequestBody HashMap map){
        return iDeptService.selectByUserId(map);
    }
}
