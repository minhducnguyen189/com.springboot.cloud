package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.bff.application.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${adapter.service.name}")
public interface ApplicationAdapterApi {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/adapter/message")
    public String getAdapterMessage();

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/adapter/message/error")
    public String getErrorMessage();

}
