package com.springboot.cloud.openfeign.openapi.client.app.config;

import com.springboot.cloud.openfeign.openapi.server.app.api.ServerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springboot.cloud.openfeign.openapi.server.app")
public class FeignClientConfig {

    @Value("${openfeign.server.name}")
    private String serverName;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ServerApi v1ApiFeignClient() {
        return new FeignClientBuilder(applicationContext)
                .forType(ServerApi.class, serverName)
                .build();
    }

}
