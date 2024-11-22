package com.stroygen.urdis2.common.client;

import com.stroygen.urdis2.common.auth.model.KakaoUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "kakaoClient", url = "https://kapi.kakao.com")
public interface KakaoClient {
    @GetMapping(value = "/v2/user/me")
    KakaoUserInfo getUserInfo(
            @RequestHeader("Content-Type") String contentType,
            @RequestHeader("Authorization") String authorization
    );
}
