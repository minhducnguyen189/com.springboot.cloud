package com.springboot.cloud.jaeger.application.adapter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdapterController {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/adapter")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello From application adapter Service");
    }

}
