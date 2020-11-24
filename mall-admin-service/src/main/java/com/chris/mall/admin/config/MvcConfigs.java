package com.chris.mall.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-22
 */
@Configuration
public class MvcConfigs implements WebMvcConfigurer {

    /**
     * The value of the 'Access-Control-Allow-Origin' header in the response must not be the
     * wildcard '*' when the request's credentials mode is 'include'.
     * The credentials mode of requests initiated by the XMLHttpRequest is controlled by the
     * withCredentials attribute.
     *
     * @param registry AccessControl registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8004").allowCredentials(true);
    }
}
