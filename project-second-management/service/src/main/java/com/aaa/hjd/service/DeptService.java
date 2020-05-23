package com.aaa.hjd.service;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.mapper.DeptMapper;
import com.aaa.hjd.model.Dept;
import com.aaa.hjd.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xxf
 * @Time: Create in 2020/5/20  22:11
 * @Description:
 */
@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

   /**
    * @Author xxf
    * @Description  搜索/查询全部
    * @Date 2:01 2020/5/21
    * @Param [where, deptName, createTime]
    * @return com.aaa.hjd.model.Dept
    * @throws
    **/
   public List<Dept> selectForFields(DeptVo deptVo) {
           List<Dept> deptList1 = deptMapper.selectForFields(deptVo);
           //判断查询出来的结果是否为空
           if (deptList1.size() > 0) {
               //不为空时
               for (int i = 0;i<deptList1.size();i++){
                   //循环，获取id作为父级id查询
                   Dept dept = deptList1.get(i);
                   Long parentId = dept.getDeptId();
                   deptVo.setParentId(null);
                   deptVo.setParentId(parentId);
                   List<Dept> deptList2 = selectForFields(deptVo);
                   //将查询的结果存进上一级
                       dept.setDeptList(deptList2);
               }
               return deptList1;
           }else {
               return null;
           }
   }

   /**
    * @Author xxf
    * @Description  批量删除
    * @Date 13:41 2020/5/23
    * @Param [ids]
    * @return java.lang.Integer
    * @throws
    **/
   public boolean deleteList(List<Dept> ids) {
       if (ids.size() > 0) {
           Integer result = deptMapper.deleteBatch(ids);
           if (result > 0){
               return true;
           }
       }
       return false;
   }

}
