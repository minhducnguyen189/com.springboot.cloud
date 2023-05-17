package com.springboot.cloud.sleuth.logback.kafka.zipkin.customer.service;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SleuthLogbackKafkaZipkinCustomerServiceApplication {
    public static void main(String[] args) {
        SLF4JBridgeHandler.install();
        SpringApplication.run(SleuthLogbackKafkaZipkinCustomerServiceApplication.class, args);
    }
}