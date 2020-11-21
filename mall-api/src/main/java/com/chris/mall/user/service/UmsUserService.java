package com.chris.mall.user.service;

import java.util.List;

import com.chris.mall.user.entity.UmsUser;

/**
 * 用户表(UmsUser)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 09:28:19
 */
public interface UmsUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UmsUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsUser 实例对象
     * @return 实例对象
     */
    UmsUser insert(UmsUser umsUser);

    /**
     * 修改数据
     *
     * @param umsUser 实例对象
     * @return 实例对象
     */
    UmsUser update(UmsUser umsUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}