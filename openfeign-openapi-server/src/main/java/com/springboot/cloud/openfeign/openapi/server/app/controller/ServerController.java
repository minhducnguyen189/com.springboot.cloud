package com.springboot.cloud.openfeign.openapi.server.app.controller;

import com.springboot.cloud.openfeign.openapi.server.app.api.DatetimeApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ServerController implements DatetimeApi {

    @Override
    public ResponseEntity<String> getServerDateTime() {
        return new ResponseEntity<>(LocalDateTime.now().toString(), HttpStatus.OK);
    }

}
