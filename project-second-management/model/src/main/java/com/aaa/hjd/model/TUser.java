package com.aaa.hjd.model;

import com.aaa.hjd.base.BaseModel;
import lombok.Data;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-05-16 13:46:07
 */
@Data
public class TUser extends BaseModel implements Serializable {
    private static final long serialVersionUID = 938447659516527171L;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 部门ID
    */
    private Long deptId;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 联系电话
    */
    private String mobile;
    /**
    * 状态 0锁定 1有效
    */
    private String status;
    /**
    * 最近访问时间
    */
    private String lastLoginTime;
    /**
    * 性别 0男 1女 2保密
    */
    private String ssex;
    /**
    * 描述
    */
    private String description;
    /**
    * 用户头像
    */
    private String avatar;
    /**
    * 用户类型 0:单位用户 1:审核用户 2:管理员
    */
    private String type;
    
    private String token;
}