package com.chris.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chris.mall.product.entity.PmsCategory;

/**
 * 商品三级分类(PmsCategory)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-21 13:11:25
 */
public interface PmsCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsCategory queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PmsCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pmsCategory 实例对象
     * @return 对象列表
     */
    List<PmsCategory> queryAll(PmsCategory pmsCategory);

    /**
     * 新增数据
     *
     * @param pmsCategory 实例对象
     * @return 影响行数
     */
    int insert(PmsCategory pmsCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PmsCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsCategory> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PmsCategory> entities);

    /**
     * 修改数据
     *
     * @param pmsCategory 实例对象
     * @return 影响行数
     */
    int update(PmsCategory pmsCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}