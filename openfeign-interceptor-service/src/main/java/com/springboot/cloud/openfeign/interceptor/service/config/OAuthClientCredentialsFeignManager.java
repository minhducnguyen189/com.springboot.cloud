package com.springboot.cloud.openfeign.interceptor.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import static java.util.Objects.isNull;


@Slf4j
public class OAuthClientCredentialsFeignManager {

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;
    private final ClientRegistration clientRegistration;

    private static final Authentication ANONYMOUS_USER_AUTHENTICATION =
            new AnonymousAuthenticationToken("key", "anonymous", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));


    public OAuthClientCredentialsFeignManager(OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager, ClientRegistration clientRegistration) {
        this.oAuth2AuthorizedClientManager = oAuth2AuthorizedClientManager;
        this.clientRegistration = clientRegistration;
    }

    public String getAccessToken() {
        try {
            OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId(clientRegistration.getRegistrationId())
                    .principal(ANONYMOUS_USER_AUTHENTICATION)
                    .build();
            OAuth2AuthorizedClient client = oAuth2AuthorizedClientManager.authorize(oAuth2AuthorizeRequest);
            if (isNull(client)) {
                throw new IllegalStateException("client credentials flow on " + clientRegistration.getRegistrationId() + " failed, client is null");
            }
            return client.getAccessToken().getTokenValue();
        } catch (Exception exp) {
            log.error("client credentials error " + exp.getMessage());
            throw new IllegalArgumentException("client credentials error " + exp.getMessage(), exp);
        }
    }

}
