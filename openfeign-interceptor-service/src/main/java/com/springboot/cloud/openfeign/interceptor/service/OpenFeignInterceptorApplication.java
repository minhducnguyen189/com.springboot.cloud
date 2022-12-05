package com.springboot.cloud.openfeign.interceptor.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignInterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignInterceptorApplication.class, args);
    }
}