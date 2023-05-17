package com.springboot.cloud.sleuth.logback.kafka.zipkin.eureka.server;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SleuthLogbackKafkaZipkinEurekaServerApplication {

    public static void main(String[] args) {
        SLF4JBridgeHandler.install();
        SpringApplication.run(SleuthLogbackKafkaZipkinEurekaServerApplication.class, args);
    }

}