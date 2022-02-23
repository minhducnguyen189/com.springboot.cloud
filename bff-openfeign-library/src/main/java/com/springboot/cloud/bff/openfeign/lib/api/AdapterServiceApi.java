package com.springboot.cloud.bff.openfeign.lib.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AdapterServiceApi {

    @RequestMapping(method = RequestMethod.GET, value = "blog/posts/{id}")
    String getPostById(@PathVariable(value = "id") String id);
}
