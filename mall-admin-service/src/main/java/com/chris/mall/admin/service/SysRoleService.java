package com.chris.mall.admin.service;

import java.util.List;

import com.chris.mall.admin.entity.SysRole;
import com.github.pagehelper.PageInfo;

/**
 * 角色(SysRole)表服务接口
 *
 * @author makejava
 * @since 2020-11-22 07:56:13
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    SysRole queryById(Long roleId);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<SysRole> queryAll();

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响数量
     */
    int update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long roleId);

    /**
     * 分页查询
     *
     * @param page  起始
     * @param limit 数量
     * @return 列表
     */
    PageInfo<SysRole> queryByPage(int page, int limit);
}