package com.stroygen.urdis2.common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "kakaoClient", url = "https://kapi.kakao.com")
public interface KakaoClient {
    @GetMapping(value = "/v2/user/me")
    ResponseEntity<String> getUserInfo(
            @RequestHeader("Content-Type") String contentType,
            @RequestHeader("Authorization") String authorization,
            @RequestParam("property_keys") String propertyKeys
    );
}
