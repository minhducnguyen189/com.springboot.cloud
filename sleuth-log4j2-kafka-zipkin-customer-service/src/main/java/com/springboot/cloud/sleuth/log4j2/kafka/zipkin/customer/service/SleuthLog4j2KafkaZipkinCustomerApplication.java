package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SleuthLog4j2KafkaZipkinCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthLog4j2KafkaZipkinCustomerApplication.class, args);
    }
}