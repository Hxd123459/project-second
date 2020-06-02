package com.aaa.hjd;

import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Dept;
import com.aaa.hjd.vo.DeptVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
     * @param deptVo 搜索+查询
     * @return
     */
    @PostMapping("/selectDeptForFields")
    ResultData selectForFields(@RequestBody DeptVo deptVo);
}
