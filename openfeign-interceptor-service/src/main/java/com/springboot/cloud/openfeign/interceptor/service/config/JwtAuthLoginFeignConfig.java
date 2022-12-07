package com.springboot.cloud.openfeign.interceptor.service.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;


public class JwtAuthLoginFeignConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("han.do@example.com", "12345");
    }

}
