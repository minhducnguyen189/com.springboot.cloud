package com.springboot.cloud.openfeign.client.credentials.interceptor.config.oauth2.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;


@Slf4j
@Service
public class OAuth2ClientService {

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    private static final Authentication ANONYMOUS_USER_AUTHENTICATION =
            new AnonymousAuthenticationToken("key", "anonymous", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));


    @Autowired
    public OAuth2ClientService(OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
        this.oAuth2AuthorizedClientManager = oAuth2AuthorizedClientManager;
    }

    public String getAccessToken(String clientRegistrationId) {
        OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId(clientRegistrationId)
                .principal(ANONYMOUS_USER_AUTHENTICATION)
                .build();
        OAuth2AuthorizedClient client = oAuth2AuthorizedClientManager.authorize(oAuth2AuthorizeRequest);
        if (isNull(client)) {
            throw new IllegalStateException("client credentials flow on " + clientRegistrationId + " failed, client is null");
        }
        return "Bearer " + client.getAccessToken().getTokenValue();
    }

}
