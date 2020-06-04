package com.aaa.hjd.controller;

import com.aaa.hjd.IDeptService;
import com.aaa.hjd.PubService;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TMappingUnit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/28
 */
@RestController
@Api(value = "单位信息",tags = "获取单位信息和修改单位信息")
public class MappingUnitController {

    @Autowired
    private PubService pubService;

    @Autowired
    private IDeptService iDeptService;

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @GetMapping("/getMappingUnit")
    @ApiOperation(value = "获取当前用户下单位信息")
    public ResultData getMappingUnit() {
        return pubService.getMappingUnit();
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 根据用户id查询单位信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/getMappingUnitByUserId")
    @ApiOperation(value = "根据用户id获取单位信息")
    public ResultData getMappingUnitByUserId(@RequestParam("userId") Long userId){
        return pubService.getMappingUnitByUserId(userId);
    }

    /**
     * @date:  2020/5/28
     * @author: 秀仔
     * @Description
     * 更新单位信息
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PostMapping("/updateMappingUnit")
    @ApiOperation(value = "更新单位信息")
    public ResultData updateMappingUnit(@RequestBody TMappingUnit tMappingUnit) {
        return pubService.updateMappingUnit(tMappingUnit);
    }

    /**
     * @Author xxf
     * @Description
     *      查询所有的单位信息+分页+搜索
     * @Date 11:53 2020/5/27
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectUnitList")
    @ApiOperation(value = "查询所有的单位信息+分页+搜索",notes = "查询所有的单位信息+分页+搜索")
    public ResultData selectUnitList(@RequestBody HashMap map){
       return iDeptService.selectUnitList(map);
    }

    /**
     * @Author xxf
     * @Description
     *      根据主键查询一条数据
     * @Date 11:06 2020/5/29
     * @Param [tMappingUnit]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectUnitOne")
    @ApiOperation(value = "根据主键查询一条数据",notes = "根据主键查询一条数据")
    public ResultData selectUnitOne(@RequestBody TMappingUnit tMappingUnit){
        return iDeptService.selectUnitOne(tMappingUnit);
    }

    /**
     * @Author xxf
     * @Description
     *      查询修改待审核的单位信息+搜索+分页
     * @Date 10:55 2020/5/31
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectAuditForUpdate")
    @ApiOperation(value = "查询修改待审核的单位信息+搜索+分页",notes = "查询修改待审核的单位信息+搜索+分页")
    public ResultData selectAuditForUpdate(@RequestBody HashMap map){
        return iDeptService.selectAuditForUpdate(map);
    }
}
