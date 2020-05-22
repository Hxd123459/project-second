package com.aaa.hjd.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_role")
public class Role implements Serializable {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "ROLE_ID")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private String modifyTime;

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public Long getRoleId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.id = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色描述
     *
     * @return REMARK - 角色描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置角色描述
     *
     * @param remark 角色描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_TIME - 修改时间
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }
}