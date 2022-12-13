package com.springboot.cloud.openfeign.interceptor.service.api;

import com.springboot.cloud.openfeign.interceptor.service.config.OAuthFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springOAuth2ResourceClient", url = "${spring.security.oauth2.url}", configuration = {OAuthFeignConfig.class})
public interface SpringOAuth2ResourceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/card")
    String getCardDetail();

}
