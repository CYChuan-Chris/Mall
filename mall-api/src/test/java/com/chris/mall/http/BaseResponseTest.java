package com.chris.mall.http;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.chris.mall.user.entity.UmsUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * 功能描述
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-23
 */
class BaseResponseTest {

    @Test
    void resetResp() {
        BaseResponse response = new BaseResponse(Status.PARAM_ERR);
        UmsUser umsUser = new UmsUser();
        umsUser.setId(System.currentTimeMillis());
        umsUser.setUsername("test_dynamic");

        // 测试一
        response.addProperty("user", umsUser);
        BaseResponse data = response.resetResp();
        System.out.println(response);
        // 新建的对象使用默认的 toString
        System.out.println(data);
        JsonMapper mapper = new JsonMapper();
        try {
            System.out.println(mapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 测试二
        System.out.println("********************多值测试***********************");
        Map<String, Object> map = new HashMap<>(2);
        map.put("token", UUID.randomUUID().toString());
        map.put("user", umsUser);
        response.addProperties(map);
        data = response.resetResp();
        System.out.println(response);
        // 新建的对象使用默认的 toString
        System.out.println(data);
        try {
            System.out.println(mapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}