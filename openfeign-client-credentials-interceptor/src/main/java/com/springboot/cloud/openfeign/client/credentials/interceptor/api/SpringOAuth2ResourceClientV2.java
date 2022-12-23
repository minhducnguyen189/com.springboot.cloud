package com.springboot.cloud.openfeign.client.credentials.interceptor.api;

import com.springboot.cloud.openfeign.client.credentials.interceptor.config.oauth2.v2.OAuth2FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springOAuth2ResourceClient2", url = "${spring.security.oauth2.url}", configuration = {OAuth2FeignConfig.class})
public interface SpringOAuth2ResourceClientV2 {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/card")
    String getCardDetail();

}
