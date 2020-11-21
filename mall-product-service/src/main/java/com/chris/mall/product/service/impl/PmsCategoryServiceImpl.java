package com.chris.mall.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.chris.mall.product.dao.PmsCategoryDao;
import com.chris.mall.product.entity.PmsCategory;
import com.chris.mall.product.service.PmsCategoryService;

/**
 * 商品三级分类(PmsCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-11-21 13:11:29
 */
@Service
public class PmsCategoryServiceImpl implements PmsCategoryService {
    @Resource
    private PmsCategoryDao pmsCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsCategory queryById(Long id) {
        return this.pmsCategoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PmsCategory> queryAllByLimit(int offset, int limit) {
        return this.pmsCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pmsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public PmsCategory insert(PmsCategory pmsCategory) {
        this.pmsCategoryDao.insert(pmsCategory);
        return pmsCategory;
    }

    /**
     * 修改数据
     *
     * @param pmsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public PmsCategory update(PmsCategory pmsCategory) {
        this.pmsCategoryDao.update(pmsCategory);
        return this.queryById(pmsCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.pmsCategoryDao.deleteById(id) > 0;
    }
}