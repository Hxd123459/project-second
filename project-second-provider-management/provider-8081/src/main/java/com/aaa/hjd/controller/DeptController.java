package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.Dept;
import com.aaa.hjd.service.DeptService;
import com.aaa.hjd.utils.CheckObjectIsNullUtils;
import com.aaa.hjd.utils.DateTimeUtils;
import com.aaa.hjd.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/22  21:46
 * @Description:
 */
@RestController
public class DeptController extends CommonController<Dept> {

    @Autowired
    private DeptService deptService;

    @Override
    public BaseService<Dept> getBaseService(){
        return deptService;
    }

    /**
     * @Author xxf
     * @Description     添加部门信息
     * @Date 22:02 2020/5/22
     * @Param [dept]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/insertDept")
    @Transactional(rollbackFor = Exception.class)
    public ResultData insertDept(@RequestBody Dept dept) {
        dept.setCreateTime(DateTimeUtils.getNow());
        try {
            Integer add = deptService.add(dept);
            if (add > 0) {
                return addDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addDataFailed();
    }

    /**
     * @Author xxf
     * @Description     修改部门信息
     * @Date 22:11 2020/5/22
     * @Param [dept]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PutMapping("/updateDept")
    @Transactional(rollbackFor = Exception.class)
    public ResultData updateDept(@RequestBody Dept dept) {
        dept.setModifyTime(DateTimeUtils.getNow());
        try {
            Integer update = deptService.update(dept);
            if (update > 0) {
                return updateDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateDataFailed();
    }

    /**
     * @Author xxf
     * @Description     删除部门信息
     * @Date 22:12 2020/5/22
     * @Param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @DeleteMapping("/deleteDept")
    @Transactional(rollbackFor = Exception.class)
    public ResultData deleteDept(@RequestBody Dept dept) {
        try {
            Integer result = deptService.deleteByPrimaryKey(dept);
            System.out.println(result);
            if (result == 1) {
                return delDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delDataFailed();
    }

    /**
     * @Author xxf
     * @Description 批量删除
     * @Date 22:14 2020/5/22
     * @Param [ids]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/

    @DeleteMapping("/deleteList")
    @Transactional(rollbackFor = Exception.class)
    public ResultData deleteList(@RequestBody List<Dept> ids){
        try {
            boolean b = deptService.deleteList(ids);
            if (b){
                return delDataSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return delDataFailed();
    }

    /**
     * @Author xxf
     * @Description 搜索/查询全部
     * @Date 15:10 2020/5/23
     * @Param [deptVo]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @PostMapping("/selectForFields")
    public ResultData selectForFields(@RequestBody DeptVo deptVo){
        List<Dept> deptList = deptService.selectForFields(deptVo);
        if (deptList.size() > 0) {
            return new ResultData("22001", "查询成功" ,deptList);
        }
        return new ResultData("12001", "暂无数据" ,null);
    }

    /**
     * @Author xxf
     * @Description 通过id查询信息
     * @Date 16:19 2020/5/23
     * @Param [deptId]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     **/
    @GetMapping("/selectOne")
    @Transactional(rollbackFor = Exception.class)
    public ResultData selectOne(@RequestParam("deptId") Long deptId) {
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        try {
            Dept dept1 = deptService.queryOne(dept);
            boolean b = CheckObjectIsNullUtils.objCheckIsNull(dept1);
            if(!b) {
                return new ResultData("22002", "查询成功" ,dept1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultData("12002", "暂无数据" ,null);
    }

}
