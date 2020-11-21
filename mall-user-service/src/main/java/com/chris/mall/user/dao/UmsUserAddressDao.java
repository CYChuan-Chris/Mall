package com.chris.mall.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chris.mall.user.entity.UmsUserAddress;

/**
 * 收货地址表(UmsUserAddress)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 10:04:13
 */
public interface UmsUserAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsUserAddress queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UmsUserAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsUserAddress 实例对象
     * @return 对象列表
     */
    List<UmsUserAddress> queryAll(UmsUserAddress umsUserAddress);

    /**
     * 新增数据
     *
     * @param umsUserAddress 实例对象
     * @return 影响行数
     */
    int insert(UmsUserAddress umsUserAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsUserAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsUserAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsUserAddress> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsUserAddress> entities);

    /**
     * 修改数据
     *
     * @param umsUserAddress 实例对象
     * @return 影响行数
     */
    int update(UmsUserAddress umsUserAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}