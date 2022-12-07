package com.tabakov.talkme.service.auth;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    boolean authenticate(String login, String password);
}
