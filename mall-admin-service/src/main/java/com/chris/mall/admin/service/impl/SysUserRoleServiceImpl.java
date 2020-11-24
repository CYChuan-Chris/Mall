package com.chris.mall.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chris.mall.admin.dao.SysUserRoleDao;
import com.chris.mall.admin.entity.SysUserRole;
import com.chris.mall.admin.service.SysUserRoleService;

/**
 * 用户与角色对应关系(SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2020-11-22 07:56:16
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRole queryById(Long id) {
        return this.sysUserRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUserRole> queryAllByLimit(int offset, int limit) {
        return this.sysUserRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole insert(SysUserRole sysUserRole) {
        this.sysUserRoleDao.insert(sysUserRole);
        return sysUserRole;
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole update(SysUserRole sysUserRole) {
        this.sysUserRoleDao.update(sysUserRole);
        return this.queryById(sysUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserRoleDao.deleteById(id) > 0;
    }
}