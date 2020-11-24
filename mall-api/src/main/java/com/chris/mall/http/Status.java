package com.chris.mall.http;

/**
 * http 状态描述（响应码，响应信息）
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-22
 */
public enum Status {
    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 参数错误
     */
    PARAM_ERR(1, "parameter error"),

    /**
     * 认证失败
     */
    AUTH_ERR(2, "invalid authentication");

    private int code;

    private String msg;

    Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
