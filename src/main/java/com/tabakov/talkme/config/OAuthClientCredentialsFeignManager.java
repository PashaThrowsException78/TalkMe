package com.tabakov.talkme.config;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OAuthClientCredentialsFeignManager {

    private String token = "";

    public String getAccessToken() {
        return token;
    }
}
