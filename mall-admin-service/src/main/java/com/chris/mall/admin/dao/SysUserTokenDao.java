package com.chris.mall.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chris.mall.admin.entity.SysUserToken;

/**
 * 系统用户Token(SysUserToken)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-22 07:56:18
 */
public interface SysUserTokenDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUserToken queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param token token
     * @return 对象列表
     */
    SysUserToken queryByToken(String token);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserToken 实例对象
     * @return 对象列表
     */
    List<SysUserToken> queryAll(SysUserToken sysUserToken);

    /**
     * 新增数据
     *
     * @param sysUserToken 实例对象
     * @return 影响行数
     */
    int insert(SysUserToken sysUserToken);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserToken> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserToken> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserToken> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserToken> entities);

    /**
     * 修改数据
     *
     * @param sysUserToken 实例对象
     * @return 影响行数
     */
    int update(SysUserToken sysUserToken);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

    /**
     * 通过 token 删除记录
     *
     * @param token token
     * @return 影响行数
     */
    int deleteByToken(String token);
}