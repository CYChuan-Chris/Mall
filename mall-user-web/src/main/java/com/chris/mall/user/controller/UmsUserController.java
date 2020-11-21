package com.chris.mall.user.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.user.entity.UmsUser;
import com.chris.mall.user.service.UmsUserService;

/**
 * 用户表(UmsUser)表控制层
 *
 * @author makejava
 * @since 2020-11-19 09:28:19
 */
@RestController
@RequestMapping("user")
public class UmsUserController {
    /**
     * 服务对象
     */
    @Reference
    private UmsUserService umsUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsUser selectOne(Long id) {
        return this.umsUserService.queryById(id);
    }

    /**
     * @return
     */
    @GetMapping("getAll")
    public List<UmsUser> all() {
        return this.umsUserService.queryAllByLimit(0, 10);
    }

}