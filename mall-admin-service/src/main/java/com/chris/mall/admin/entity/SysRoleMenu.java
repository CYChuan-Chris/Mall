package com.chris.mall.admin.entity;

import java.io.Serializable;

/**
 * 角色与菜单对应关系(SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-11-22 07:56:50
 */
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = -44316950330964094L;

    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}