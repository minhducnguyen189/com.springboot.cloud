package com.springboot.cloud.jaeger.application.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JaegerApplicationAdapter {
    public static void main(String[] args) {
        SpringApplication.run(JaegerApplicationAdapter.class, args);
    }
}