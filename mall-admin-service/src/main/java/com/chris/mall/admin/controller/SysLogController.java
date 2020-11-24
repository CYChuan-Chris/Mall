package com.chris.mall.admin.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.entity.SysLog;
import com.chris.mall.admin.service.SysLogService;
import com.chris.mall.http.BaseResponse;
import com.github.pagehelper.PageInfo;

/**
 * 系统日志(SysLog)表控制层
 *
 * @author makejava
 * @since 2020-11-23 20:52:51
 */
@RestController
@RequestMapping("sys")
public class SysLogController {
    /**
     * 服务对象
     */
    @Resource
    private SysLogService sysLogService;

    /**
     * 查询所有的日志
     *
     * @param page  起始
     * @param limit 数量
     * @return 列表
     */
    @GetMapping("log/list")
    public BaseResponse getAllLog(int page, int limit) {
        PageInfo<SysLog> pageInfo = this.sysLogService.queryAll(page, limit);
        return new BaseResponse().addProperty("page", pageInfo).resetResp();
    }

}