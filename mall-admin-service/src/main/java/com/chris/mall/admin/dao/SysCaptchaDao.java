package com.chris.mall.admin.dao;

import com.chris.mall.admin.entity.SysCaptcha;

/**
 * 系统验证码(SysCaptcha)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-22 07:52:30
 */
public interface SysCaptchaDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    SysCaptcha queryById(String uuid);

    /**
     * 新增数据
     *
     * @param sysCaptcha 实例对象
     * @return 影响行数
     */
    int insert(SysCaptcha sysCaptcha);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}