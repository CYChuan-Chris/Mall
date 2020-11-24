package com.chris.mall.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码(SysCaptcha)实体类
 *
 * @author makejava
 * @since 2020-11-22 07:52:25
 */
public class SysCaptcha implements Serializable {
    private static final long serialVersionUID = 226548813892367931L;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private Date expireTime;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

}