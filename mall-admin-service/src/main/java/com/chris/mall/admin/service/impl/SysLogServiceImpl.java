package com.chris.mall.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chris.mall.admin.dao.SysLogDao;
import com.chris.mall.admin.entity.SysLog;
import com.chris.mall.admin.service.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 系统日志(SysLog)表服务实现类
 *
 * @author makejava
 * @since 2020-11-23 20:52:51
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogDao sysLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysLog queryById(Long id) {
        return this.sysLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysLog> queryAll(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return PageInfo.of(this.sysLogDao.queryAll(null));
    }

    /**
     * 新增数据
     *
     * @param sysLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysLog insert(SysLog sysLog) {
        this.sysLogDao.insert(sysLog);
        return sysLog;
    }

    /**
     * 修改数据
     *
     * @param sysLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysLog update(SysLog sysLog) {
        this.sysLogDao.update(sysLog);
        return this.queryById(sysLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysLogDao.deleteById(id) > 0;
    }
}