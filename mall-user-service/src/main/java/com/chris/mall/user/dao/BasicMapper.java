package com.chris.mall.user.dao;

import java.util.List;

/**
 * 基础通用 Mapper, 使用泛型进行扩展，由子类实现后完成 sql 映射
 * 网上流行的插件有 tx.mapper, mybatis plus等，不需对通用 mapper 进行映射
 * 其原理为：约定表名、主键等关键信息的获取方式，在映射解析前进行动态 sql 拼接
 * 对于基础单表查询，该方式可完美实现既定需求
 *
 * @author Chris Chen
 * @version [Mall]
 * @since Created in 2020-11-18
 */
public interface BasicMapper<T> {
    /**
     * 查询所有的单表数据
     *
     * @return 列表
     */
    List<T> selectAll();

    /**
     * 查询一条数据
     *
     * @return 行
     */
    T selectOne(T t);

    /**
     * 插入一条数据
     *
     * @param t 行
     */
    void insertOne(T t);

    /**
     * 更新一条数据
     *
     * @param t 行
     */
    void updateOne(T t);

    /**
     * 删除一条数据
     *
     * @param primaryKey 主键
     */
    void deleteOne(String primaryKey);
}
