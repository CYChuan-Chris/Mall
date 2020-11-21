package com.chris.mall.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.chris.mall.user.dao.UmsUserDao;
import com.chris.mall.user.entity.UmsUser;
import com.chris.mall.user.service.UmsUserService;

/**
 * 用户表(UmsUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 09:28:19
 */
@Service
public class UmsUserServiceImpl implements UmsUserService {
    @Resource
    private UmsUserDao umsUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsUser queryById(Long id) {
        return this.umsUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsUser> queryAllByLimit(int offset, int limit) {
        return this.umsUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsUser 实例对象
     * @return 实例对象
     */
    @Override
    public UmsUser insert(UmsUser umsUser) {
        this.umsUserDao.insert(umsUser);
        return umsUser;
    }

    /**
     * 修改数据
     *
     * @param umsUser 实例对象
     * @return 实例对象
     */
    @Override
    public UmsUser update(UmsUser umsUser) {
        this.umsUserDao.update(umsUser);
        return this.queryById(umsUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsUserDao.deleteById(id) > 0;
    }
}