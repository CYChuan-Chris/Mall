package com.chris.mall.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chris.mall.admin.entity.SysLog;

/**
 * 系统日志(SysLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-23 20:52:50
 */
public interface SysLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysLog queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysLog 实例对象
     * @return 对象列表
     */
    List<SysLog> queryAll(SysLog sysLog);

    /**
     * 新增数据
     *
     * @param sysLog 实例对象
     * @return 影响行数
     */
    int insert(SysLog sysLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysLog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysLog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysLog> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysLog> entities);

    /**
     * 修改数据
     *
     * @param sysLog 实例对象
     * @return 影响行数
     */
    int update(SysLog sysLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}