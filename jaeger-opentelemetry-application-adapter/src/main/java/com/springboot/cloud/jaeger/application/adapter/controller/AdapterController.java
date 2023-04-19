package com.springboot.cloud.jaeger.application.adapter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdapterController {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/adapter/message")
    public ResponseEntity<String> getMessage() {
        log.info("AdapterController: getMessage");
        return ResponseEntity.ok("Hello From application adapter Service");
    }

}
