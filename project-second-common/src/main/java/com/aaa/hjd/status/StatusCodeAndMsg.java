package com.aaa.hjd.status;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/12 0012
 * Time: 18:08
 * Description:
 *  统一定义返回值参数
 */
public enum StatusCodeAndMsg {
    LOGIN_SUCCESS("20001","登陆成功"),
    LOGIN_FAILED("10001", "登录失败"),
    USER_EXIST("20002", "用户存在"),
    USER_NOT_EXIST("10002", "用户不存在"),
    PASSWORD_WRONG("10003", "密码错误"),
    USER_LOCKED("10004", "账号被锁定"),
    LOGOUT_WRONG("10005", "用户退出异常"),
    ADD_DATA_SUCCESS("20003","新增成功"),
    ADD_DATA_FAILED("10006","删除失败"),
    DEL_DATA_SUCCESS("20004","删除成功"),
    DEL_DATA_FAILED("10007","删除失败"),
    UPDATE_DATA_SUCCESS("20005","更新成功"),
    UPDATE_DATA_FAILED("10008","更新失败"),
    SYSTEM_ERROR("10009","系统内部异常");
    private String code;
    private String msg;
    StatusCodeAndMsg(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
