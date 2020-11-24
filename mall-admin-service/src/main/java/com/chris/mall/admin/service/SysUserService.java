package com.chris.mall.admin.service;

import com.chris.mall.admin.entity.SysUser;
import com.chris.mall.admin.viewobj.Login;
import com.github.pagehelper.PageInfo;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-11-22 07:56:10
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUser queryById(Long userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    PageInfo<SysUser> queryAll(int offset, int limit, String username);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

    /**
     * 用户登录鉴权
     *
     * @param login 登录信息
     * @return 鉴权信息
     */
    String loginVerify(Login login);

    /**
     * 查询登录用户信息
     *
     * @param token token
     * @return user
     */
    SysUser getUserByToken(String token);

    /**
     * 登出, 删除对应的 token 记录
     *
     * @param token 登录信息
     * @return 单条数据
     */
    int logout(String token);
}