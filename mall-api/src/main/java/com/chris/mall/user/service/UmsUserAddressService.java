package com.chris.mall.user.service;

import java.util.List;

import com.chris.mall.user.entity.UmsUserAddress;

/**
 * 收货地址表(UmsUserAddress)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 10:04:13
 */
public interface UmsUserAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsUserAddress queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UmsUserAddress> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsUserAddress 实例对象
     * @return 实例对象
     */
    UmsUserAddress insert(UmsUserAddress umsUserAddress);

    /**
     * 修改数据
     *
     * @param umsUserAddress 实例对象
     * @return 实例对象
     */
    UmsUserAddress update(UmsUserAddress umsUserAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}