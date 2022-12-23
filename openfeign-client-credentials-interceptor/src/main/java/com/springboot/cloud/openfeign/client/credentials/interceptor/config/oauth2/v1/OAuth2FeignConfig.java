package com.springboot.cloud.openfeign.client.credentials.interceptor.config.oauth2.v1;


import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class OAuth2FeignConfig {

    public static final String CLIENT_REGISTRATION_ID = "keycloak";

    private final OAuth2ClientService oAuth2ClientService;

    public OAuth2FeignConfig(OAuth2ClientService oAuth2ClientService) {
        this.oAuth2ClientService = oAuth2ClientService;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, this.oAuth2ClientService.getAccessToken(CLIENT_REGISTRATION_ID));
        };
    }


}
