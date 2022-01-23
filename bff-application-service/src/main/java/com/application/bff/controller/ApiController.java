package com.application.bff.controller;

import com.application.bff.service.AdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiController {

    @Autowired
    private AdapterService adapterService;

    @RequestMapping(method = RequestMethod.GET, path = "application/posts/{id}", produces = {"application/json"})
    public ResponseEntity<String> getPostById(@PathVariable("id") String id) {
        return new ResponseEntity<>(adapterService.getPostById(id), HttpStatus.OK);
    }


}
