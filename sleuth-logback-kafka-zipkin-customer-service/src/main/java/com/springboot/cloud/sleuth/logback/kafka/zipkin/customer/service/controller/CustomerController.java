package com.springboot.cloud.sleuth.logback.kafka.zipkin.customer.service.controller;

import com.springboot.cloud.sleuth.logback.kafka.zipkin.customer.service.api.ProductServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private ProductServiceApi productServiceApi;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/customer/message")
    public ResponseEntity<String> getMessage() {
        log.info("Start CustomerController: getMessage");
        log.info("Call Product Service method getProductMessage: 1");
        String productMessage = this.productServiceApi.getProductMessage();
        log.info("Content From Product Service: " + productMessage);
        log.info("Call Product Service method getProductMessage: 2");
        String productMessage2 = this.productServiceApi.getProductMessage();
        log.info("Content From Product Service: " + productMessage2);
        return ResponseEntity.ok("Hello From application adapter Service");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/customer/message/error")
    public ResponseEntity<String> getErrorMessage() {
        log.info("CustomerController: getErrorMessage");
        throw new RuntimeException("CustomerController: getErrorMessage");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/customer/message/error2")
    public ResponseEntity<String> getErrorMessage2() {
        log.info("CustomerController: getErrorMessage2");
        log.info("Call Product Service method getProductMessage");
        String productMessage = this.productServiceApi.getProductMessage();
        log.info("Content From Product Service: " + productMessage);
        log.info("Call Product Service method getErrorMessage");
        this.productServiceApi.getErrorMessage();
        return ResponseEntity.ok("CustomerController: getErrorMessage");
    }

}
