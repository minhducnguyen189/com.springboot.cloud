package com.springboot.cloud.openfeign.interceptor.service.config.oauth2.v2;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

public class OAuth2FeignConfig {

    public static final String CLIENT_REGISTRATION_ID = "keycloak";

    private final ClientRegistrationRepository clientRegistrationRepository;
    private final OAuth2AuthorizedClientService authorizedClientService;

    public OAuth2FeignConfig(ClientRegistrationRepository clientRegistrationRepository,
                             OAuth2AuthorizedClientService authorizedClientService) {
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.authorizedClientService = authorizedClientService;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
                new OAuthClientCredentialsFeignManager(authorizedClientManager(), clientRegistrationRepository);
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, clientCredentialsFeignManager.getAccessToken(CLIENT_REGISTRATION_ID));
        };
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager() {
        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build();
        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
        return authorizedClientManager;
    }

}
