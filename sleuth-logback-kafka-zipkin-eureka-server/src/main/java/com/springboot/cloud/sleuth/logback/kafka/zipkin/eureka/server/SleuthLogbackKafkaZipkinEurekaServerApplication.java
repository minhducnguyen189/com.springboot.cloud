package com.springboot.cloud.sleuth.logback.kafka.zipkin.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SleuthLogbackKafkaZipkinEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthLogbackKafkaZipkinEurekaServerApplication.class, args);
    }

}