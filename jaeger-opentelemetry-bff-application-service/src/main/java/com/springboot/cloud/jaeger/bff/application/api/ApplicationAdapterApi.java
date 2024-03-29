package com.springboot.cloud.jaeger.bff.application.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${adapter.service.name}")
public interface ApplicationAdapterApi {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/adapter/message")
    public String getAdapterMessage();

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/adapter/message/error")
    public String getErrorMessage();

}
