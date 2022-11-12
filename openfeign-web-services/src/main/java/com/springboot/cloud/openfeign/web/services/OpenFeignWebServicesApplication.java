package com.springboot.cloud.openfeign.web.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignWebServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignWebServicesApplication.class, args);
    }
}