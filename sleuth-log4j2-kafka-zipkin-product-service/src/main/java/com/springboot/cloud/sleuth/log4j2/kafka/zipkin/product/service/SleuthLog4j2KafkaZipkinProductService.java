package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.product.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SleuthLog4j2KafkaZipkinProductService {

    public static void main(String[] args) {
        SpringApplication.run(SleuthLog4j2KafkaZipkinProductService.class, args);
    }

}