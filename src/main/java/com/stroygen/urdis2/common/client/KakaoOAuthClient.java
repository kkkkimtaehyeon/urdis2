package com.stroygen.urdis2.common.client;


import com.stroygen.urdis2.common.auth.dto.KakaoTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoOAuth2Client", url = "https://kauth.kakao.com")
public interface KakaoOAuthClient {

    @PostMapping(value = "/oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    KakaoTokenResponseDto getToken(
            @RequestHeader("Content-Type") String contentType,
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );
}
