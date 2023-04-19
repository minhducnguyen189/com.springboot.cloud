package com.springboot.cloud.jaeger.opentelemetry.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JaegerEurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(JaegerEurekaServer.class, args);
    }
}