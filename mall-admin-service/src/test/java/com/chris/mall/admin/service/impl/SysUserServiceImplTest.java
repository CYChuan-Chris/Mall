package com.chris.mall.admin.service.impl;

import java.util.UUID;

import org.apache.tomcat.util.json.Token;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chris.mall.admin.service.SysUserService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-22
 */
@SpringBootTest
class SysUserServiceImplTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    void loginVerify() {
        System.out.println(Token.newToken(8, UUID.randomUUID().toString()));
    }

    @Test
    void getUserByToken() {
        // 不存在的token
        sysUserService.getUserByToken(UUID.randomUUID().toString());
    }
}