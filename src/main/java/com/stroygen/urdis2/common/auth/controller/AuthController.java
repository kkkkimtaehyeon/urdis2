//package com.stroygen.urdis2.common.auth.controller;
//
//import com.stroygen.urdis2.common.auth.model.KakaoUserInfo;
//import com.stroygen.urdis2.common.auth.service.KakaoOAuthService;
//import com.stroygen.urdis2.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class AuthController {
//    private final KakaoOAuthService kakaoOAuthService;
//    private final MemberService memberService;
//
//    @GetMapping("/login/oauth2/code/kakao")
//    public String oauthLogin(@RequestParam String code) {
//        return "";
//    }
//
//}
