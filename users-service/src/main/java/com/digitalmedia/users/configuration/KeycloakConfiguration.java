package com.digitalmedia.users.configuration;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

    @Value("${dm.keycloak.serverUrl}")
    private String serverUrl;
    @Value("${dm.keycloak.realm}")
    private String realm;
    @Value("${dm.keycloak.clientId}")
    private String clientId;
    @Value("${dm.keycloak.clientSecret}")
    private String clientSecret;

    @Bean
    public Keycloak buildClient(){
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }
}
