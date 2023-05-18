package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.customer.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${product.service.name}")
public interface ProductServiceApi {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/product/message")
    public String getProductMessage();

    @RequestMapping(method = RequestMethod.GET, path = "/v1/application/product/message/error")
    public String getErrorMessage();

}