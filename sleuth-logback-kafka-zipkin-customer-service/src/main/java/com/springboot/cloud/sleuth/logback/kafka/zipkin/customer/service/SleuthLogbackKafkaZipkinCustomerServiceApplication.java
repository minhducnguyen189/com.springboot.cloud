package com.springboot.cloud.sleuth.logback.kafka.zipkin.customer.service;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SleuthLogbackKafkaZipkinCustomerServiceApplication {
    public static void main(String[] args) {
        SLF4JBridgeHandler.install();
        SpringApplication.run(SleuthLogbackKafkaZipkinCustomerServiceApplication.class, args);
    }
}