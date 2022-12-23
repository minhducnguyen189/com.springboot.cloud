package com.springboot.cloud.openfeign.client.credentials.interceptor.controller;

import com.springboot.cloud.openfeign.client.credentials.interceptor.api.SpringOAuth2ResourceClient;
import com.springboot.cloud.openfeign.client.credentials.interceptor.api.SpringOAuth2ResourceClientV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignInterceptorController {

    @Autowired
    private SpringOAuth2ResourceClient springOAuth2ResourceClient;

    @Autowired
    private SpringOAuth2ResourceClientV2 springOAuth2ResourceClientV2;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/oauth2/auth/interceptor/card")
    public ResponseEntity<String> getCardMessage() {
        return ResponseEntity.ok(this.springOAuth2ResourceClient.getCardDetail());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v2/oauth2/auth/interceptor/card")
    public ResponseEntity<String> getCardMessageV2() {
        return ResponseEntity.ok(this.springOAuth2ResourceClientV2.getCardDetail());
    }

}
