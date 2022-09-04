package com.application.adapter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/hello")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from blog application adapter", HttpStatus.OK);
    }

}
