package com.springboot.cloud.sleuth.logback.kafka.zipkin.bff.application.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SleuthLogbackKafkaZipkinBffApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthLogbackKafkaZipkinBffApplication.class, args);
    }
}