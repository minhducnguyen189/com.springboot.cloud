package com.springboot.cloud.jaeger.bff.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class JaegerBffApplication {
    public static void main(String[] args) {
        SpringApplication.run(JaegerBffApplication.class, args);
    }
}