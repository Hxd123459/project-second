package com.aaa.hjd.base;

import static com.aaa.hjd.status.StatusCodeAndMsg.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/12 0012
 * Time: 18:06
 * Description:
 *  通用controller，就是实现consumer和provider统一返回值
 */
public class BaseController {
    /**
     * 登陆成功，使用系统消息
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登陆成功，使用自定义msg
     * @param msg
     * @return
     */
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登陆成功，返回自定义msg，code
     * @param msg
     * @param code
     * @return
     */
    protected ResultData loginSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }
    /**
     * 登陆成功，返回自定义msg，code data
     * @return
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setData(data);
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登陆失败，使用系统消息
     * @return
     */
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * 登陆失败，使用自定义msg
     * @param msg
     * @return
     */
    protected ResultData loginFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登陆失败，返回自定义msg，code
     * @param msg
     * @param code
     * @return
     */
    protected ResultData loginFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 注册用户时 /登陆录时 ，用户已存在，使用系统信息
     * @return
     */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * 注册用户时/登陆录时  ，用户已存在，使用自定义msg
     * @return
     */
    protected ResultData userExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 注册用户时/登陆录时 ，用户已存在，使用自定义msg,code
     * @return
     */
    protected ResultData userExist(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 注册用户时/登陆录时 ，用户不存在，使用系统信息
     * @return
     */
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;
    }
    /**
     * 注册用户时/登陆录时 ，用户不存在，使用自定义msg
     * @return
     */
    protected ResultData userNotExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 注册用户时/登陆录时 ，用户不存在，使用自定义code，msg
     * @return
     */
    protected ResultData userNotExist(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 密码错误，使用系统信息
     * @return
     */
    protected ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }
    /**
     * 密码错误，使用自定义msg
     * @return
     */
    protected ResultData passwordWrong(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 密码错误，使用自定义msg,code
     * @return
     */
    protected ResultData passwordWrong(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 用户锁定，使用系统信息
     * @return
     */
    protected ResultData userLocked(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        return resultData;
    }
    /**
     * 用户锁定，使用自定义msg
     * @return
     */
    protected ResultData userLocked(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 用户锁定，使用自定义msg，code
     * @return
     */
    protected ResultData userLocked(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登出，使用系统信息
     * @return
     */
    protected ResultData logoutWrong(){
        ResultData resultData = new ResultData();
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        resultData.setCode(LOGOUT_WRONG.getCode());
        return resultData;
    }
    /**
     * 登出，使用自定义 msg
     * @return
     */
    protected ResultData logoutWrong(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        resultData.setCode(msg);
        return resultData;
    }
    /**
     * 登出，使用自定义msg,code
     * @return
     */
    protected ResultData logoutWrong(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 成功新增数据
     * @return
     */
    protected ResultData addDataSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_SUCCESS.getCode());
        resultData.setMsg(ADD_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 成功新增数据
     * @return
     */
    protected ResultData addDataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 成功新增数据
     * @return
     */
    protected ResultData addDataSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(msg);
        resultData.setMsg(code);
        return resultData;
    }

    /**
     * 新增数据失败
     * @return
     */
    protected ResultData addDataFailed(){
        ResultData resultData = new ResultData();
        resultData.setMsg(ADD_DATA_FAILED.getMsg());
        resultData.setCode(ADD_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 新增数据失败
     * @return
     */
    protected ResultData addDataFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(ADD_DATA_FAILED.getMsg());
        resultData.setCode(msg);
        return resultData;
    }
    /**
     * 新增数据失败
     * @return
     */
    protected ResultData addDataFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 成功删除数据
     * @return
     */
    protected ResultData delDataSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_DATA_SUCCESS.getCode());
        resultData.setMsg(DEL_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 成功删除数据
     * @return
     */
    protected ResultData delDataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 成功删除数据
     * @return
     */
    protected ResultData delDataSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 删除数据失败
     * @return
     */
    protected ResultData delDataFailed(){
        ResultData resultData = new ResultData();
        resultData.setMsg(DEL_DATA_FAILED.getMsg());
        resultData.setCode(DEL_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 删除数据失败
     * @return
     */
    protected ResultData delDataFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(DEL_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 删除数据失败
     * @return
     */
    protected ResultData delDataFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 成功更新数据
     * @return
     */
    protected ResultData updateDataSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_SUCCESS.getCode());
        resultData.setMsg(UPDATE_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 成功更新数据
     * @return
     */
    protected ResultData updateDataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 成功更新数据
     * @return
     */
    protected ResultData updateDataSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 更新数据失败
     * @return
     */
    protected ResultData updateDataFailed(){
        ResultData resultData = new ResultData();
        resultData.setMsg(UPDATE_DATA_FAILED.getMsg());
        resultData.setCode(UPDATE_DATA_FAILED.getCode());
        return resultData;
    }

    /**
     * 更新数据失败
     * @return
     */
    protected ResultData updateDataFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(UPDATE_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 更新数据失败
     * @return
     */
    protected ResultData updateDataFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 系统异常
     * @return
     */
    protected ResultData systemError(){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_ERROR.getCode());
        resultData.setData(SYSTEM_ERROR.getMsg());
        return resultData;
    }
    /**
     * 系统异常
     * @return
     */
    protected ResultData systemError(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_ERROR.getCode());
        resultData.setData(msg);
        return resultData;
    }
    /**
     * 系统异常
     * @return
     */
    protected ResultData systemError(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setData(msg);
        return resultData;
    }

    /**
     * 角色查询成功
     * @param obj
     * @return
     */
    protected ResultData selectRoleSuccess(Object obj){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_ROLE_SUCCESS.getCode());
        resultData.setMsg(SELECT_ROLE_SUCCESS.getMsg());
        resultData.setData(obj);
        return resultData;
    }

    /**
     * 角色查询失败
     * @return
     */
    protected ResultData selectRoleError(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_ROLE_FAILED.getCode());
        resultData.setMsg(SELECT_ROLE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除角色失败
     * @return
     */
    protected ResultData deleteRoleError(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_ROLE_FAILED.getCode());
        resultData.setMsg(DELETE_ROLE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除角色成功
     * @return
     */
    protected ResultData deleteRoleSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_ROLE_SUCCESS.getCode());
        resultData.setMsg(DELETE_ROLE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 新增角色成功
     * @return
     */
    protected ResultData insertRoleSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_ROLE_SUCCESS.getCode());
        resultData.setMsg(INSERT_ROLE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 新增角色失败
     * @return
     */
    protected ResultData insertRoleFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_ROLE_FAILED.getCode());
        resultData.setMsg(INSERT_ROLE_FAILED.getMsg());
        return resultData;
    }



    /**
     * 查询数据成功
     * @return
     */
   protected ResultData selectSuccess(Object data){
       ResultData resultData = new ResultData();
       resultData.setCode(GET_DATA_SUCCESS.getCode());
       resultData.setMsg(GET_DATA_SUCCESS.getMsg());
       resultData.setData(data);
       return resultData;
   }
    /**
     * 查询数据失败
     * @return
     */
    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(GET_DATA_FAILED.getCode());
        resultData.setMsg(GET_DATA_FAILED.getMsg());
        return resultData;
    }
}
