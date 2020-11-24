package com.chris.mall.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * http 接口响应基本类型
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @see ResponseBodyAdvice 响应写出前处理方式之一
 * @since Created in 2020-11-22
 */
public class BaseResponse {
    private int code;
    private String msg;

    /**
     * 成功重置的属性列表
     */
    private List<String> nameList;

    /**
     * 动态属性值
     */
    private final Map<String, Object> properties = new HashMap<>();

    public BaseResponse() {
        this(Status.SUCCESS);
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(Status status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResponse addProperty(String name, Object value) {
        this.properties.put(name, value);
        return this;
    }

    public BaseResponse addProperties(Map<String, Object> map) {
        this.properties.putAll(map);
        return this;
    }

    /**
     * 以此对象为基准，动态增加新的属性，产生新的对象
     * 注意：新的对象使用默认 toString 方法，不包含新增加的属性，但可进行序列化
     *
     * @return this
     */
    public BaseResponse resetResp() {
        if (MapUtils.isEmpty(properties)) {
            return this;
        }
        BeanGenerator generator = new BeanGenerator();
        generator.setSuperclass(this.getClass());
        // 增加新的属性
        nameList = new ArrayList<>(properties.size());
        properties.forEach((k, v) -> {
            if (StringUtils.isNotBlank(k) && v != null) {
                generator.addProperty(k, v.getClass());
                nameList.add(k);
            }
        });
        // 创建新的对象并设置属性值
        BaseResponse resp = (BaseResponse)generator.create();
        BeanMap beanMap = BeanMap.create(resp);
        beanMap.put("code", this.code);
        beanMap.put("msg", this.msg);
        nameList.forEach(name -> beanMap.put(name, properties.get(name)));
        return resp;
    }

    /**
     * 子类继承后拼接自己的属性
     *
     * @return JsonBuilder
     */
    protected ToStringBuilder toStringBuilder() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("code",
            code).append("msg", msg);
        // 补充输出成功添加的新属性
        if (CollectionUtils.isNotEmpty(nameList)) {
            nameList.forEach(name -> builder.append(name, properties.get(name)));
        }
        return builder;
    }

    @Override
    public String toString() {
        return toStringBuilder().toString();
    }
}
