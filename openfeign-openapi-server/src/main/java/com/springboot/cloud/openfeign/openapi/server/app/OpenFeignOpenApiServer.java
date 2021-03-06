package com.springboot.cloud.openfeign.openapi.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OpenFeignOpenApiServer {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOpenApiServer.class, args);
    }

}
