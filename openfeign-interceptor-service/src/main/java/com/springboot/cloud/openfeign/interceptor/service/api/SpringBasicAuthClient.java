package com.springboot.cloud.openfeign.interceptor.service.api;

import com.springboot.cloud.openfeign.interceptor.service.config.BasicAuthFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springBasicAuthClient", url = "${spring.security.basic.url}", configuration = {BasicAuthFeignConfig.class})
public interface SpringBasicAuthClient {

    @RequestMapping(method = RequestMethod.GET, path = "/welcome", consumes = MediaType.TEXT_HTML_VALUE)
    String sayWelcome();

}
