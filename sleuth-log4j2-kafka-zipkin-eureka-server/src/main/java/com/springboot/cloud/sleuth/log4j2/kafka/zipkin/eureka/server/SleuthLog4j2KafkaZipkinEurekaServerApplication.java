package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SleuthLog4j2KafkaZipkinEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthLog4j2KafkaZipkinEurekaServerApplication.class, args);
    }
}