package com.chris.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author GREAT
 */
@SpringBootApplication
@MapperScan(basePackages = "com.chris.mall.user.dao")
public class MallUserServiceApplication {

    public static void main(String[] args) {
            SpringApplication.run(MallUserServiceApplication.class, args);
    }

}
