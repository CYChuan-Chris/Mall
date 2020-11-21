package com.chris.mall.product;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfigBinding;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author GREAT
 */
@SpringBootApplication
@MapperScan("com.chris.mall.product.dao")
public class MallProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductServiceApplication.class, args);
    }

}
