package com.stroygen.urdis2.common.provider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtTokenProviderTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void createAccessToken() {
        String email = "kth1927@naver.com";
        String accessToken = jwtTokenProvider.createAccessToken(email);
        System.out.println(accessToken);
    }

    @Test
    void createRefreshToken() {
    }
}