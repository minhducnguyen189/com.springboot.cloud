package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.product.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/product/message")
    public ResponseEntity<String> getMessage() {
        log.info("ProductController: getMessage");
        return ResponseEntity.ok("Hello From product Service");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/product/message/error")
    public ResponseEntity<String> getErrorMessage() {
        log.info("ProductController: getErrorMessage");
        throw new RuntimeException("ProductController: getErrorMessage");
    }

}
