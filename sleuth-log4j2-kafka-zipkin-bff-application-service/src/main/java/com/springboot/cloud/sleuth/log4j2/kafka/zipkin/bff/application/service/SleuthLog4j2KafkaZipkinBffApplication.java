package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.bff.application.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SleuthLog4j2KafkaZipkinBffApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthLog4j2KafkaZipkinBffApplication.class, args);
    }
}