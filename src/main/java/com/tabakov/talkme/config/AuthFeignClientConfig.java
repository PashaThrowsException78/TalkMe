package com.tabakov.talkme.config;


import com.tabakov.talkme.client.AuthClient;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AuthFeignClientConfig {

    private final OAuthClientCredentialsFeignManager manager;

    public AuthFeignClientConfig(OAuthClientCredentialsFeignManager manager) {
        this.manager = manager;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + manager.getAccessToken());
        };
    }
}
