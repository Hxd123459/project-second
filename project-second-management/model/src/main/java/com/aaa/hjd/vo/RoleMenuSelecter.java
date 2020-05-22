package com.aaa.hjd.vo;

import com.aaa.hjd.model.Role;
import com.aaa.hjd.model.RoleMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * User: Aurora
 * Date: 2020/5/22
 * Time: 1:37
 * 修改角色信息和角色菜单的参数vo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class RoleMenuSelecter implements Serializable {
    //角色参数
    private Role role;
    //菜单参数
    private List<RoleMenu> roleMenus;
}
