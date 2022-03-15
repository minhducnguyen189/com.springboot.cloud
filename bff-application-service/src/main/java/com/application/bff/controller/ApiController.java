package com.application.bff.controller;

import com.application.bff.adapters.AdapterServerApi;
import com.application.bff.service.AdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private AdapterService adapterService;

    @Autowired
    private AdapterServerApi adapterServerApi;

    @RequestMapping(method = RequestMethod.GET, path = "application/posts/{id}", produces = {"application/json"})
    public ResponseEntity<String> getPostById(@PathVariable("id") String id) {
        return new ResponseEntity<>(adapterService.getPostById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/client/hello")
    public ResponseEntity<String> getHelloFromAdapter() {
        return new ResponseEntity<>(adapterServerApi.getHelloResponse(), HttpStatus.OK);
    }

}
