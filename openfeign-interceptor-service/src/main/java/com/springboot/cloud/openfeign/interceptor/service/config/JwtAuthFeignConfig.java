package com.springboot.cloud.openfeign.interceptor.service.config;

import com.springboot.cloud.openfeign.interceptor.service.api.SpringJwtLoginClient;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.MimeTypeUtils;

import java.util.Collection;
import java.util.UUID;

public class JwtAuthFeignConfig {

    private final SpringJwtLoginClient springJwtLoginClient;

    public JwtAuthFeignConfig(SpringJwtLoginClient springJwtLoginClient) {
        this.springJwtLoginClient = springJwtLoginClient;
    }

    @Bean
    public RequestInterceptor basicAuthRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Authorization", "Bearer " + this.getHeader());
        };
    }

    private String getHeader() {
        Collection<String> authToken = this.springJwtLoginClient.getAccountDetails("username").headers().get("authorization");
        return authToken != null ? authToken.iterator().next() : "";
    }

}
