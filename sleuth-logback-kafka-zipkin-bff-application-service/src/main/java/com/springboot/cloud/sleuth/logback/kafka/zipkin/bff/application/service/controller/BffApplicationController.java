package com.springboot.cloud.sleuth.logback.kafka.zipkin.bff.application.service.controller;

import com.springboot.cloud.sleuth.logback.kafka.zipkin.bff.application.service.api.CustomerServiceApi;
import com.springboot.cloud.sleuth.logback.kafka.zipkin.bff.application.service.api.ProductServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class BffApplicationController {

    @Autowired
    private CustomerServiceApi customerServiceApi;
    @Autowired
    private ProductServiceApi productServiceApi;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/bff/customer/message")
    public ResponseEntity<String> getCustomerMessage() {
        log.info("BffApplicationController: getCustomerMessage");
        return ResponseEntity.ok(this.customerServiceApi.getCustomerMessage());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/bff/customer/message/error")
    public ResponseEntity<String> getCustomerErrorMessage() {
        log.info("BffApplicationController: getCustomerErrorMessage");
        return ResponseEntity.ok(this.customerServiceApi.getErrorMessage());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/bff/customer/message/error2")
    public ResponseEntity<String> getCustomerErrorMessage2() {
        log.info("BffApplicationController: getCustomerErrorMessage2");
        return ResponseEntity.ok(this.customerServiceApi.getErrorMessage2());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/bff/customer/product/message")
    public ResponseEntity<String> getCustomerProductMessage() {
        log.info("BffApplicationController: getCustomerProductMessage");
        log.info("BffApplicationController: getCustomerMessage");
        String customerMessage = this.customerServiceApi.getCustomerMessage();
        log.info("Content From Customer Service: " + customerMessage);
        log.info("BffApplicationController: getProductService");
        String productMessage = this.productServiceApi.getProductMessage();
        log.info("Content From Product Service: " + productMessage);
        return ResponseEntity.ok("Customer Message: " + customerMessage + " - Product Message: " + productMessage);
    }

}
