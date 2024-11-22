package com.stroygen.urdis2.common.auth.controller;

import com.stroygen.urdis2.common.auth.service.KakaoOAuth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final KakaoOAuth2Service kakaoOAuth2Service;


    // 인가코드를 받아서 토큰을 요청
    @GetMapping("/login/oauth2/code/kakao")
    public String requestKakaoToken(@RequestParam String code) {
        String accessToken = kakaoOAuth2Service.getToken(code);
        kakaoOAuth2Service.getUserInfo(accessToken);
        return "";
    }

}
