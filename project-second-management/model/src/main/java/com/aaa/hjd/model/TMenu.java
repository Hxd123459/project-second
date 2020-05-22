package com.aaa.hjd.model;

import com.aaa.hjd.base.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * (TMenu)实体类
 *
 * @author makejava
 * @since 2020-05-20 23:35:24
 */
@Data
public class TMenu   implements Serializable {
    private static final long serialVersionUID = 531585883878376543L;
    /**
    * 菜单/按钮ID
    */
    @Id
    @Column(name = "MENU_ID")
    private Long id;
    /**
    * 上级菜单ID
    */
    @Column(name = "PARENT_ID")
    private Long parentId;
    /**
    * 菜单/按钮名称
    */
    @Column(name = "MENU_NAME")
    private String menuName;
    /**
    * 对应路由path
    */
    @Column(name = "PATH")
    private String path;
    /**
    * 对应路由组件component
    */
    @Column(name = "COMPONENT")
    private String component;
    /**
    * 权限标识
    */
    @Column(name = "PERMS")
    private String perms;
    /**
    * 图标
    */
    @Column(name = "ICON")
    private String icon;
    /**
    * 类型 0菜单 1按钮
    */
    @Column(name = "TYPE")
    private String type;

    private String createTime;

    private String modifyTime;

    /**
    * 排序
    */
    @Column(name = "ORDER_NUM")
    private Object orderNum;

    private List<TMenu> submenu;


}