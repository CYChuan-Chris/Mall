package com.chris.mall.admin.service;

import javax.servlet.http.HttpServletResponse;

/**
 * 系统验证码(SysCaptcha)表服务接口
 *
 * @author makejava
 * @since 2020-11-22 07:52:31
 */
public interface SysCaptchaService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid     主键
     * @param response 响应
     */
    void getCaptcha(String uuid, HttpServletResponse response);

    /**
     * 校验输入验证码
     *
     * @param uuid    uuid
     * @param captcha 文本
     * @return boolean
     */
    boolean checkCaptcha(String uuid, String captcha);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    boolean deleteById(String uuid);

}