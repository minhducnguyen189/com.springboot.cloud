package com.springboot.cloud.sleuth.logback.kafka.zipkin.product.service;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SleuthLogbackKafkaZipkinProductService {

    public static void main(String[] args) {
        SLF4JBridgeHandler.install();
        SpringApplication.run(SleuthLogbackKafkaZipkinProductService.class, args);
    }

}