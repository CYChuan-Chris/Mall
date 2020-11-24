package com.chris.mall.admin.service;

import java.util.List;
import java.util.Map;

import com.chris.mall.admin.entity.SysMenu;
import com.github.pagehelper.PageInfo;

/**
 * 菜单管理(SysMenu)表服务接口
 *
 * @author makejava
 * @since 2020-11-22 07:56:49
 */
public interface SysMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    SysMenu queryById(Long menuId);

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu insert(SysMenu sysMenu);

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu update(SysMenu sysMenu);

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    boolean deleteById(Long menuId);

    /**
     * 获取所有的菜单
     *
     * @return 响应
     */
    Map<String, Object> getAllMenuNav();

    /**
     * 查询所有菜单分页
     *
     * @return pageInfo
     */
    List<SysMenu> getAllMenu();
}