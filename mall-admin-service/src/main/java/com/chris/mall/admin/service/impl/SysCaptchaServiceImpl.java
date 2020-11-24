package com.chris.mall.admin.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.chris.mall.admin.dao.SysCaptchaDao;
import com.chris.mall.admin.entity.SysCaptcha;
import com.chris.mall.admin.service.SysCaptchaService;
import com.chris.mall.util.random.Captcha;

/**
 * 系统验证码(SysCaptcha)表服务实现类
 *
 * @author makejava
 * @since 2020-11-22 07:52:33
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl implements SysCaptchaService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Resource
    private SysCaptchaDao sysCaptchaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     */
    @Override
    public void getCaptcha(String uuid, HttpServletResponse response) {
        Captcha captcha = new Captcha(75, 25, 4);
        BufferedImage image = captcha.create();
        String text = captcha.getText();
        if (StringUtils.isBlank(text)) {
            LOGGER.error("create captcha error");
            return;
        }
        SysCaptcha sysCaptcha = new SysCaptcha();
        sysCaptcha.setCode(text);
        sysCaptcha.setUuid(uuid);
        LocalDateTime now = LocalDateTime.now();
        sysCaptcha.setExpireTime(Date.from(now.plusMinutes(2).toInstant(ZoneOffset.UTC)));
        this.sysCaptchaDao.insert(sysCaptcha);
        try {
            Captcha.writeOut(image, response.getOutputStream());
        } catch (IOException e) {
            LOGGER.error("write out captcha error" + e.getMessage());
        }
    }

    /**
     * 校验输入验证码
     *
     * @param uuid    uuid
     * @param captcha 文本
     * @return boolean
     */
    @Override
    public boolean checkCaptcha(String uuid, String captcha) {
        SysCaptcha sysCaptcha = this.sysCaptchaDao.queryById(uuid);

        return sysCaptcha != null && sysCaptcha.getExpireTime() != null && StringUtils
            .equalsIgnoreCase(sysCaptcha.getCode(), captcha) && new Date().before(
            sysCaptcha.getExpireTime());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.sysCaptchaDao.deleteById(uuid) > 0;
    }
}