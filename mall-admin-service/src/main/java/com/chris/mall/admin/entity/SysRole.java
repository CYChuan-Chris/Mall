package com.chris.mall.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色(SysRole)实体类
 *
 * @author makejava
 * @since 2020-11-22 07:56:13
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = -67157724441129741L;

    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建者ID
     */
    private Long createUserId;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}