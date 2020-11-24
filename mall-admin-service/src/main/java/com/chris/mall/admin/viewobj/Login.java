package com.chris.mall.admin.viewobj;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 功能描述
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-22
 */
public class Login {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String uuid;

    @NotBlank
    private String captcha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    /**
     * 子类继承后拼接自己的属性
     *
     * @return JsonBuilder
     */
    protected ToStringBuilder toStringBuilder() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("username", username)
                                                                  .append("uuid", uuid).append(
                "captcha", captcha);
    }

    @Override
    public String toString() {
        return toStringBuilder().toString();
    }
}
