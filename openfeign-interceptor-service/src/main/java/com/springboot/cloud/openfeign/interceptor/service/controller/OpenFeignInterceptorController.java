package com.springboot.cloud.openfeign.interceptor.service.controller;

import com.springboot.cloud.openfeign.interceptor.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignInterceptorController {

    @Autowired
    private SpringBasicAuthClient springBasicAuthClient;

    @Autowired
    private SpringCustomHeaderClient springCustomHeaderClient;

    @Autowired
    private SpringJwtAuthClient springJwtAuthClient;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/basic/auth/interceptor/welcome")
    public ResponseEntity<String> getWelcomeMessageWithBasicAuthInterceptor() {
        return ResponseEntity.ok(this.springBasicAuthClient.sayWelcome());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/custom/header/interceptor/welcome")
    public ResponseEntity<String> getWelcomeMessageWithCustomerHeaders() {
        return ResponseEntity.ok(this.springCustomHeaderClient.sayWelcome());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/jwt/auth/interceptor/loan")
    public ResponseEntity<String> getLoadMessage() {
        return ResponseEntity.ok(this.springJwtAuthClient.getLoanDetail());
    }

}
