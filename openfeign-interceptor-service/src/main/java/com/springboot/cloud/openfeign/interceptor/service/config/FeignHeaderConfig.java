package com.springboot.cloud.openfeign.interceptor.service.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

public class FeignHeaderConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("random-uuid", UUID.randomUUID().toString());
            requestTemplate.header("Authorization", "Basic dXNlcjoxMjM0NQ==");
        };
    }

}
