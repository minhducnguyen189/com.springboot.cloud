package com.springboot.cloud.openfeign.interceptor.service.api;

import com.springboot.cloud.openfeign.interceptor.service.config.JwtAuthFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springJwtAuthClient", url = "${spring.security.jwt.url}", configuration = {JwtAuthFeignConfig.class})
public interface SpringJwtAuthClient {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/loan")
    String getLoanDetail();

}
