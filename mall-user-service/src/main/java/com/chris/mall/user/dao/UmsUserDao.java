package com.chris.mall.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chris.mall.user.entity.UmsUser;

/**
 * 用户表(UmsUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 09:30:42
 */
public interface UmsUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UmsUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsUser 实例对象
     * @return 对象列表
     */
    List<UmsUser> queryAll(UmsUser umsUser);

    /**
     * 新增数据
     *
     * @param umsUser 实例对象
     * @return 影响行数
     */
    int insert(UmsUser umsUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsUser> entities);

    /**
     * 修改数据
     *
     * @param umsUser 实例对象
     * @return 影响行数
     */
    int update(UmsUser umsUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}