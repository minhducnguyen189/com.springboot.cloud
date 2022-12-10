package com.springboot.cloud.openfeign.interceptor.service.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//We should not put the annotation @Configuration right here because it will apply the BasicAuthRequestInterceptor for all FeignClients
public class BasicAuthFeignConfig {

    @Value("${spring.security.basic.username}")
    private String username;

    @Value("${spring.security.basic.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }

}
