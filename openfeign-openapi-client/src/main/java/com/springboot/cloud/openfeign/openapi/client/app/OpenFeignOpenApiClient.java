package com.springboot.cloud.openfeign.openapi.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OpenFeignOpenApiClient {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOpenApiClient.class, args);
    }

}
