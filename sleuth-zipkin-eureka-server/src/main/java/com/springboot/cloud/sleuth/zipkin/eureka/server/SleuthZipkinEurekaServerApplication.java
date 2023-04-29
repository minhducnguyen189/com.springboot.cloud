package com.springboot.cloud.sleuth.zipkin.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SleuthZipkinEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinEurekaServerApplication.class, args);
    }
}