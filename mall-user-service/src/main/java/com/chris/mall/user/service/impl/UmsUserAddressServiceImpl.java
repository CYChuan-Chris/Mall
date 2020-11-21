package com.chris.mall.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.chris.mall.user.dao.UmsUserAddressDao;
import com.chris.mall.user.entity.UmsUserAddress;
import com.chris.mall.user.service.UmsUserAddressService;

/**
 * 收货地址表(UmsUserAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 10:04:13
 */
@Service
public class UmsUserAddressServiceImpl implements UmsUserAddressService {
    @Resource
    private UmsUserAddressDao umsUserAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsUserAddress queryById(Long id) {
        return this.umsUserAddressDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsUserAddress> queryAllByLimit(int offset, int limit) {
        return this.umsUserAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsUserAddress 实例对象
     * @return 实例对象
     */
    @Override
    public UmsUserAddress insert(UmsUserAddress umsUserAddress) {
        this.umsUserAddressDao.insert(umsUserAddress);
        return umsUserAddress;
    }

    /**
     * 修改数据
     *
     * @param umsUserAddress 实例对象
     * @return 实例对象
     */
    @Override
    public UmsUserAddress update(UmsUserAddress umsUserAddress) {
        this.umsUserAddressDao.update(umsUserAddress);
        return this.queryById(umsUserAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsUserAddressDao.deleteById(id) > 0;
    }
}