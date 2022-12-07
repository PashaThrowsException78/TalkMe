package com.tabakov.talkme.service.auth;

import com.tabakov.talkme.auth.AuthDTO;
import com.tabakov.talkme.client.AuthClient;
import com.tabakov.talkme.config.OAuthClientCredentialsFeignManager;
import com.tabakov.talkme.repo.AdminCredsRepository;
import com.tabakov.talkme.util.PasswordEncoder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class AuthServiceImpl implements AuthService{

    private final OAuthClientCredentialsFeignManager manager;
    private final AdminCredsRepository adminCredsRepository;

    private AuthDTO auth = new AuthDTO();

    public AuthServiceImpl(OAuthClientCredentialsFeignManager manager, AdminCredsRepository adminCredsRepository) {
        this.manager = manager;
        this.adminCredsRepository = adminCredsRepository;
    }

    /*
        Это временное решение, сейчас обновление токена работать не будет.
        Чтобы работало, нужно вызывать этот метод (напр. по созданию бина), и затем дёргать метод refresh по расписанию.
        Сделать это за выделенное на тестовое задание время я не успел, но делается это по аналогии.
     */
    @Scheduled(fixedDelay = 604800, timeUnit = TimeUnit.SECONDS)
    public void authFeignProgramFeignClient() {
        AuthClient.getAuth().ifPresentOrElse(x -> {
                auth = x;
                manager.setToken(auth.getAccessToken().replaceAll("\"", ""));
            System.out.println("set new token: " + auth.getAccessToken());
        }, () -> {
            System.out.println("unsuccessful auth, try again in 60 seconds");
            try {
                Thread.sleep(60000);
                authFeignProgramFeignClient(); // ToDo: заменить рекурсивный вызов бесконечным циклом
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean authenticate(String login, String password) {
        return adminCredsRepository.existsAdminCredsByLoginAndPassword(login,
                PasswordEncoder.get_SHA_512_SecurePassword(password));
    }
}
