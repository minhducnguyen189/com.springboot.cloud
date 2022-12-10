package com.springboot.cloud.openfeign.interceptor.service.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

public class FeignHeaderConfig {

    @Value("${spring.security.basic.token}")
    private String token;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("random-uuid", UUID.randomUUID().toString());
            requestTemplate.header("Authorization", token);
        };
    }

}
