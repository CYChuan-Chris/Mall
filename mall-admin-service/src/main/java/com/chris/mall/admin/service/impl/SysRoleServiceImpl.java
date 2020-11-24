package com.chris.mall.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chris.mall.admin.dao.SysRoleDao;
import com.chris.mall.admin.entity.SysRole;
import com.chris.mall.admin.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-11-22 07:56:14
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Long roleId) {
        return this.sysRoleDao.queryById(roleId);
    }

    /**
     * 分页查询
     *
     * @param page  起始
     * @param limit 数量
     * @return 列表
     */
    @Override
    public PageInfo<SysRole> queryByPage(int page, int limit) {
        PageHelper.startPage(page, limit);
        return PageInfo.of(this.sysRoleDao.queryAll(null));
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<SysRole> queryAll() {
        return this.sysRoleDao.queryAll(null);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole insert(SysRole sysRole) {
        this.sysRoleDao.insert(sysRole);
        return sysRole;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SysRole sysRole) {
        return this.sysRoleDao.update(sysRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roleId) {
        return this.sysRoleDao.deleteById(roleId) > 0;
    }
}