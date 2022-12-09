package com.springboot.cloud.openfeign.interceptor.service.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class JwtAuthLoginFeignConfig {

    @Value("${spring.security.jwt.credentials.username}")
    private String username;

    @Value("${spring.security.jwt.credentials.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }

}
