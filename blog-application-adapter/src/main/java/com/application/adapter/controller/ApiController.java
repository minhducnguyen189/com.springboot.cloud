package com.application.adapter.controller;

import com.application.adapter.models.request.Filter;
import com.application.adapter.models.request.Post;
import com.application.adapter.models.response.PostResponse;
import com.application.adapter.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;


@Controller
public class ApiController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET, path = "blog/posts/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") String id) {
        return new ResponseEntity<>(todoService.getPostById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "blog/posts")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(todoService.createPost(post), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "blog/posts/{id}")
    public ResponseEntity<String> updatePost(@PathVariable("id") String id, @RequestBody Post post) {
        todoService.updatePost(id, post);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "blog/posts")
    public ResponseEntity<List<PostResponse>> getPosts(@PathParam("page") int page, @PathParam("sortKey") @Nullable String key) {
        return new ResponseEntity<>(todoService.getPosts(page, key), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "blog/posts/filter")
    public ResponseEntity<List<PostResponse>> filterPosts(@RequestBody @NotNull @Valid Filter filter) {
        return new ResponseEntity<>(todoService.filterPosts(filter), HttpStatus.OK);
    }
}
