package com.application.bff.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "adapter.service.api", url = "${adapter.service.url}")
public interface AdapterServiceApi {

    @RequestMapping(method = RequestMethod.GET, value = "blog/posts/{id}")
    String getPostById(@PathVariable(value = "id") String id);
}
