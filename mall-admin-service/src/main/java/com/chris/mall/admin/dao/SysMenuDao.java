package com.chris.mall.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chris.mall.admin.entity.SysMenu;

/**
 * 菜单管理(SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-22 07:56:48
 */
public interface SysMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    SysMenu queryById(Long menuId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysMenu 实例对象
     * @return 对象列表
     */
    List<SysMenu> queryAll(SysMenu sysMenu);

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 影响行数
     */
    int insert(SysMenu sysMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenu> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysMenu> entities);

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 影响行数
     */
    int update(SysMenu sysMenu);

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 影响行数
     */
    int deleteById(Long menuId);

}