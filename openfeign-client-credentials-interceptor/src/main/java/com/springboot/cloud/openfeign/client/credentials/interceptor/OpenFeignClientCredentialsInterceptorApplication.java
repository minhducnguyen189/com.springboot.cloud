package com.springboot.cloud.openfeign.client.credentials.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignClientCredentialsInterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignClientCredentialsInterceptorApplication.class, args);
    }
}