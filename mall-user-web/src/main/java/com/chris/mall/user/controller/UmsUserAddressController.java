package com.chris.mall.user.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.user.entity.UmsUserAddress;
import com.chris.mall.user.service.UmsUserAddressService;

/**
 * 收货地址表(UmsUserAddress)表控制层
 *
 * @author makejava
 * @since 2020-11-19 10:04:14
 */
@RestController
@RequestMapping("umsUserAddress")
public class UmsUserAddressController {
    /**
     * 服务对象
     */
    @Reference
    private UmsUserAddressService umsUserAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsUserAddress selectOne(Long id) {
        return this.umsUserAddressService.queryById(id);
    }

}