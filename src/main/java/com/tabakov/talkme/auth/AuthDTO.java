package com.tabakov.talkme.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthDTO {

    private String accessToken = "";

    private String refreshToken = "";

    private Long expires = 0L;
}
