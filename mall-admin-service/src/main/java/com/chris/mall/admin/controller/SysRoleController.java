package com.chris.mall.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.entity.SysRole;
import com.chris.mall.admin.service.SysRoleService;
import com.chris.mall.http.BaseResponse;
import com.github.pagehelper.PageInfo;

/**
 * 角色(SysRole)表控制层
 *
 * @author makejava
 * @since 2020-11-22 07:56:14
 */
@RestController
@RequestMapping("sys")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 查询列表数据
     *
     * @param page  起始
     * @param limit 数量
     * @return 单条数据
     */
    @GetMapping("role/list")
    public BaseResponse getRoleList(int page, int limit) {
        PageInfo<SysRole> pageInfo = this.sysRoleService.queryByPage(page, limit);
        return new BaseResponse().addProperty("page", pageInfo).resetResp();
    }

    /**
     * 查询数据
     *
     * @param id 主键
     * @return 列表
     */
    @GetMapping("role/select")
    public BaseResponse getRole(Long id) {
        List<SysRole> roleList = this.sysRoleService.queryAll();
        return new BaseResponse().addProperty("list", roleList).resetResp();
    }

    /**
     * 查询数据
     *
     * @param roleId 主键
     * @return 列表
     */
    @GetMapping("role/info/{roleId}")
    public BaseResponse getRoleInfo(@PathVariable Long roleId) {
        SysRole role = this.sysRoleService.queryById(roleId);
        return new BaseResponse().addProperty("role", role).resetResp();
    }

    /**
     * 保持数据
     *
     * @param sysRole 角色信息
     * @return resp
     */
    @PostMapping("role/save")
    public BaseResponse saveRole(@RequestBody SysRole sysRole) {
        this.sysRoleService.insert(sysRole);
        return new BaseResponse();
    }

    /**
     * 更新数据
     *
     * @param sysRole 主键
     * @return 列表
     */
    @PostMapping("role/update")
    public BaseResponse updateRole(@RequestBody SysRole sysRole) {
        this.sysRoleService.update(sysRole);
        return new BaseResponse();
    }

    /**
     * 删除数据
     *
     * @param roleId 主键
     * @return resp
     */
    @PostMapping("role/delete")
    public BaseResponse deleteRole(@RequestBody Long roleId) {
        this.sysRoleService.deleteById(roleId);
        return new BaseResponse();
    }
}