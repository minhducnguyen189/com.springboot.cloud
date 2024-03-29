package com.springboot.cloud.jaeger.bff.application.controller;

import com.springboot.cloud.jaeger.bff.application.api.ApplicationAdapterApi;
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
    private ApplicationAdapterApi applicationAdapterApi;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/bff/adapter/message")
    public ResponseEntity<String> getAdapterMessage() {
        log.info("BffApplicationController: getAdapterMessage");
        return ResponseEntity.ok(this.applicationAdapterApi.getAdapterMessage());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/bff/adapter/message/error")
    public ResponseEntity<String> getAdapterErrorMessage() {
        log.info("BffApplicationController: getAdapterErrorMessage");
        return ResponseEntity.ok(this.applicationAdapterApi.getErrorMessage());
    }
}
