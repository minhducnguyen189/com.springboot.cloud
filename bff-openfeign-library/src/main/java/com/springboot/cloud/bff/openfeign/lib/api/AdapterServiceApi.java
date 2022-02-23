package com.springboot.cloud.bff.openfeign.lib.api;

import feign.Param;
import feign.RequestLine;

public interface AdapterServiceApi {

    @RequestLine("GET blog/posts/{id}")
    Object getPostById(@Param(value = "id") String id);
}
