package com.springboot.cloud.bff.openfeign.lib.controller;

import com.springboot.cloud.bff.openfeign.lib.service.PostService;
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
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET, path = "application/posts/{id}", produces = {"application/json"})
    public ResponseEntity<String> getPostById(@PathVariable("id") String id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }


}
