package com.chris.mall.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author GREAT
 */
@SpringBootApplication
@MapperScan("com.chris.mall.admin.dao")
public class MallAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminServiceApplication.class, args);
    }

}
