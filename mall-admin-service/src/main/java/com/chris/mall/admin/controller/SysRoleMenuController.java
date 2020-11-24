package com.chris.mall.admin.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.entity.SysRoleMenu;
import com.chris.mall.admin.service.SysRoleMenuService;

/**
 * 角色与菜单对应关系(SysRoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-11-22 07:56:51
 */
@RestController
@RequestMapping("sysRoleMenu")
public class SysRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRoleMenu selectOne(Long id) {
        return this.sysRoleMenuService.queryById(id);
    }

}