package com.springboot.cloud.openfeign.interceptor.service.api;

import com.springboot.cloud.openfeign.interceptor.service.config.JwtAuthFeignConfig;
import com.springboot.cloud.openfeign.interceptor.service.config.JwtAuthLoginFeignConfig;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springJwtLoginClient", url = "${spring.security.jwt.url}", configuration = {JwtAuthLoginFeignConfig.class})
public interface SpringJwtLoginClient {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/accounts/{username}")
    Response getAccountDetails(@PathVariable("username") String username);

}
