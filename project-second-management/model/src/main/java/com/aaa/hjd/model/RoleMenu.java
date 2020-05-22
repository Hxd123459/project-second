package com.aaa.hjd.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Table(name = "t_role_menu")
public class RoleMenu implements Serializable {
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * @return ROLE_ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return MENU_ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}