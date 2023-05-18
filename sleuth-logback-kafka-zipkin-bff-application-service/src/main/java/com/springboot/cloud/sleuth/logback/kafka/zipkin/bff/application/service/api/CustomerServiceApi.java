package com.springboot.cloud.sleuth.logback.kafka.zipkin.bff.application.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${service.customer.name}")
public interface CustomerServiceApi {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/customer/message")
    public String getCustomerMessage();

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/customer/message/error")
    public String getErrorMessage();

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/customer/message/error2")
    public String getErrorMessage2();

}
