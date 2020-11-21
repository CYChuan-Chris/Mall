package com.chris.mall.product.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.product.entity.PmsCategory;
import com.chris.mall.product.service.PmsCategoryService;

/**
 * 商品三级分类(PmsCategory)表控制层
 *
 * @author makejava
 * @since 2020-11-21 13:11:31
 */
@RestController
@RequestMapping("product")
public class PmsCategoryController {
    /**
     * 服务对象
     */
    @Reference
    private PmsCategoryService pmsCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PmsCategory selectOne(Long id) {
        return this.pmsCategoryService.queryById(id);
    }

}