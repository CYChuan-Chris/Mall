package com.chris.mall.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mall.admin.service.SysCaptchaService;

/**
 * 系统验证码(SysCaptcha)表控制层
 *
 * @author makejava
 * @since 2020-11-22 07:52:35
 */
@RestController
public class SysCaptchaController {
    /**
     * 服务对象
     */
    @Resource
    private SysCaptchaService sysCaptchaService;

    /**
     * 通过主键查询单条数据
     * 先根据前端传递的 uuid 生成对应的验证码，存入数据库，并将其返回前端
     *
     * @param uuid 主键
     */
    @GetMapping("captcha.jpg")
    public void getCaptcha(@NotBlank String uuid, HttpServletResponse response) {
        this.sysCaptchaService.getCaptcha(uuid, response);
    }

}