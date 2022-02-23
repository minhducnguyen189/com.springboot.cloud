package com.springboot.cloud.bff.openfeign.lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.springboot.cloud.openfeign.lib.service", "com.springboot.cloud.bff.openfeign.lib"})
public class BffOpenFeignLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffOpenFeignLibraryApplication.class, args);
    }

}
