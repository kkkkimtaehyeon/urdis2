//package com.stroygen.urdis2.common.auth.service;
//
//import com.stroygen.urdis2.common.auth.dto.KakaoTokenResponseDto;
//import com.stroygen.urdis2.common.auth.model.KakaoUserInfo;
//import com.stroygen.urdis2.common.client.KakaoClient;
//import com.stroygen.urdis2.common.client.KakaoOAuthClient;
//import com.stroygen.urdis2.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class KakaoOAuthService {
//    private final KakaoOAuthClient kakaoOAuthClient;
//    private final KakaoClient kakaoClient;
//
//    @Value("${kakao.client-id}")
//    private String clientId;
//    @Value("${kakao.client-secret}")
//    private String clientSecret;
//    @Value("${kakao.redirect-uri}")
//    private String redirectUri;
//    private static final String GRANT_TYPE = "authorization_code";
//
//    public void processLogin(String code) {
//        String token = getToken(code);
//        KakaoUserInfo kakaoUserInfo = getUserInfo(token);
//    }
//
//    private String getToken(String code) {
//        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
//        KakaoTokenResponseDto response = kakaoOAuthClient.getToken(contentType, GRANT_TYPE, clientId, clientSecret, redirectUri, code);
//
//        return response.getAccessToken();
//    }
//
//    private KakaoUserInfo getUserInfo(String accessToken) {
//        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
//        String authorization = "Bearer " + accessToken;
//
//        try {
//            KakaoUserInfo kakaoUserInfo = kakaoClient.getUserInfo(contentType, authorization);
//            return kakaoUserInfo;
//        } catch (Exception e) {
//            throw new RuntimeException("카카오톡 사용자 정보를 불러오는데 실패했습니다.");
//        }
//    }
//
//}