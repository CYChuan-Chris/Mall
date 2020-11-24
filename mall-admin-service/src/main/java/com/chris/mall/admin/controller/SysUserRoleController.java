package com.chris.mall.admin.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.entity.SysUserRole;
import com.chris.mall.admin.service.SysUserRoleService;

/**
 * 用户与角色对应关系(SysUserRole)表控制层
 *
 * @author makejava
 * @since 2020-11-22 07:56:17
 */
@RestController
@RequestMapping("sysUserRole")
public class SysUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUserRole selectOne(Long id) {
        return this.sysUserRoleService.queryById(id);
    }

}