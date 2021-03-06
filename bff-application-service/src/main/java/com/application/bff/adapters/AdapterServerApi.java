package com.application.bff.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "blog-adapter-service")
public interface AdapterServerApi {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/sayHello")
    String getHelloResponse();

}
