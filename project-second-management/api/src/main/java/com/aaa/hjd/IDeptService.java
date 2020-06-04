package com.aaa.hjd;

import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Audit;
import com.aaa.hjd.model.Dept;
import com.aaa.hjd.model.TMappingUnit;
import com.aaa.hjd.vo.DeptVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/23  20:25
 * @Description:
 */
@FeignClient(value = "system-interface")
public interface IDeptService {
    /**
     * @Author xxf
     * @Description 添加部门信息
     * @Date 16:28 2020/5/23
     * @Param [dept]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/insertDept")
    ResultData insertDept(@RequestBody Dept dept);

    /**
     * @Author xxf
     * @Description 修改部门信息
     * @Date 16:37 2020/5/23
     * @Param [dept]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PutMapping("/updateDept")
    ResultData updateDept(@RequestBody Dept dept);

    /**
     * @Author xxf
     * @Description 删除部门信息
     * @Date 16:40 2020/5/23
     * @Param [dept]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @DeleteMapping("/deleteDept")
    ResultData deleteDept(@RequestBody Dept dept);

    /**
     * @Author xxf
     * @Description  批量删除
     * @Date 16:54 2020/5/23
     * @Param [ids]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @DeleteMapping("/deleteDeptList")
    ResultData deleteList(@RequestBody List<Dept> ids);

    /**
     * @Author xxf
     * @Description 根据id查询数据
     * @Date 16:58 2020/5/23
     * @Param [deptId]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @GetMapping("/selectDeptOne")
    ResultData selectOne(@RequestParam("deptId") Long deptId);


    /**
     * @param deptVo 部门搜索+查询
     * @return
     */
    @PostMapping("/selectDeptForFields")
    ResultData selectForFields(@RequestBody DeptVo deptVo);

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
    ResultData selectAuditForUnitInfo(@RequestBody HashMap map);

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
    ResultData toAuditForUnit(@RequestBody Audit audit);

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
    ResultData selectAuditForUpdate(@RequestBody HashMap map);

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
    ResultData insertAudit(@RequestBody Audit audit);

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
    ResultData selectUnitList(@RequestBody HashMap map);

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
    ResultData selectAuditByUserId(@RequestBody HashMap map);

    /**
     * @Author xxf
     * @Description
     *  通过单位id查询评分记录，并分页
     * @Date 17:13 2020/5/28
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectScoreByUnitId")
    ResultData selectScoreByUnitId(@RequestBody HashMap map);

    /**
     * @Author xxf
     * @Description
     * 添加评分记录，并修改单位评分值
     * @Date 10:10 2020/5/29
     * @Param [score]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping(value = "/insertToScore",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData insertToScore(@RequestPart(value = "file",required = false) MultipartFile file,
                                    @RequestParam(value = "score") Integer score,
                                    @RequestParam(value = "unitId")Long unitId,
                                    @RequestParam(value = "scorePlus",required = false)Integer scorePlus,
                                    @RequestParam(value = "reason")String reason,
                                    @RequestParam(value = "scoreSubtract",required = false)Integer scoreSubtract);


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
    ResultData selectByUserId(@RequestBody HashMap map);

    /**
     * @Author xxf
     * @Description
     *      查询一条数据
     * @Date 11:06 2020/5/29
     * @Param [tMappingUnit]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectUnitOne")
    ResultData selectUnitOne(@RequestBody TMappingUnit tMappingUnit);

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
    ResultData submitAudit(@RequestBody Audit audit);

}
