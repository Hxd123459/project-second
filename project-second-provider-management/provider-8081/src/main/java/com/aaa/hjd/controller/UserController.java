package com.aaa.hjd.controller;

import com.aaa.hjd.base.BaseService;
import com.aaa.hjd.base.CommonController;
import com.aaa.hjd.base.ResultData;
import com.aaa.hjd.model.TUser;
import com.aaa.hjd.service.UserService;
import com.aaa.hjd.vo.UpdateUserVo;
import com.aaa.hjd.vo.UserSelectVo;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.ws.api.pipe.Tube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author 19435
 * user : 秀仔
 * Data: 2020/5/22
 */
@RestController
public class UserController extends CommonController<TUser> {
    @Autowired
    private UserService userService;

    @Override
    public BaseService<TUser> getBaseService() {
        return userService;
    }

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有用户信息带分页
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @PostMapping("/getUserAll")
    public ResultData getUserAll(@RequestBody HashMap<String, Integer> map){
        //获取分页数据
        PageInfo userAll = userService.getUserAll(map);
        if (0 < userAll.getTotal()) {
            //userAll.getTotal()为总条数，数据存在
            return selectSuccess(userAll);
        }
        return selectFailed();
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 查询所有角色
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("/getRoleAll")
    public ResultData getRoleAll() {
        //获取数据
        List<HashMap<String, Object>> roleAll = userService.getRoleAll();
        if (null != roleAll && 0 < roleAll.size()){
            //数据存在
            return selectSuccess(roleAll);
        }
        return selectFailed();
    }

    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据id获取用户的所有角色
     * @param [id]
     * @return java.util.List<java.lang.Long>
     * @throws
     */
    @GetMapping("/getUserRoleByID")
    public ResultData getUserRoleByID(@RequestParam("id") Long id){
        System.out.println(id);
        if (null != id){
            //传入参数不为inull执行查询
            List<Long> userRoleByID = userService.getUserRoleByID(id);
            if (null != userRoleByID && 0 < userRoleByID.size()){
                //数据存在
                return selectSuccess(userRoleByID);
            }
        }
        return selectFailed();
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据ids删除所有用户
     * @param []
     * @return java.lang.Integer
     * @throws
     */
    @DeleteMapping("/deleteUserByIDs")
    public ResultData deleteUserByIDs (@RequestBody List<Object> ids){
        if (null != ids && 0 < ids.size()){
            //数组中有数据
            return batchDelete(ids);
        }
        return delDataFailed();
    }
    /**
     * @date:  2020/5/22
     * @author: 秀仔
     * @Description
     * 根据用户id修改用户信息
     * @param []
     * @return java.lang.Integer
     * @throws
     */
    @PostMapping("/updataUserByID")
    public ResultData updataUserByID (@RequestBody UpdateUserVo updataUserVo) {
        //更新用户信息
        Integer integer = userService.updataUserByID(updataUserVo);
        if (null != integer && 0 < integer){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 新增用户
     * @param [map]
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @PutMapping("/addUser")
    public ResultData addUser(@RequestBody UpdateUserVo updataUserVo){
        //新增用户信息
        ResultData resultData = userService.addUser(updataUserVo);
        if (null != resultData){
            return resultData;
        }
        return addDataFailed();
    }
    /**
     * @date:  2020/5/23
     * @author: 秀仔
     * @Description
     * 获取部门层级列表
     * @param []
     * @return com.aaa.hjd.base.ResultData
     * @throws
     */
    @GetMapping("/getDeptName")
    public ResultData getDeptName() {
        List<HashMap<String, Object>> list = userService.getDept(0L);
        if (null != list && 0 < list.size()){
            return selectSuccess(list);
        }
        return selectFailed();
    }


    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表状态值
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("getUserStatus")
    public ResultData getUserStatus(){
        //查询数据
        List<HashMap<String, Object>> userStatus = userService.getUserStatus();
        if (null != userStatus && 0 < userStatus.size()){
            //返回结果集
            return selectSuccess(userStatus);
        }
        return selectFailed();
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 获取用户字典表性别
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @GetMapping("getUserSsex")
    public ResultData getUserSsex(){
        //查询
        List<HashMap<String, Object>> userSsex = userService.getUserSsex();
        if (null != userSsex && 0 < userSsex.size()){
            //返回结果集
            return selectSuccess(userSsex);
        }
        return null;
    }

    /**
     * @date:  2020/5/25
     * @author: 秀仔
     * @Description
     * 模糊分页查询
     * @param [userSelectVo]
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     * @throws
     */
    @PostMapping("/getUser")
    List<HashMap<String, Object>> selectUser(@RequestBody UserSelectVo userSelectVo){
        System.out.println(userSelectVo);
        //TODO --未完成xmlsql有错
        List<HashMap<String, Object>> list = userService.selectUser(userSelectVo);
        return list;
    }

}
