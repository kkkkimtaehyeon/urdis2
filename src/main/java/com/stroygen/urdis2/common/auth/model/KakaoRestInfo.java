package com.stroygen.urdis2.common.auth.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class KakaoRestInfo {
    @Value("${kakao.client-id}")
    private String clientId;
    @Value("${kakao.client-secret}")
    private String clientSecret;
    @Value("${kakao.redirect-uri}")
    private String redirectUri;
    @Value("${kakao.scope}")
    private String scope;
    private static final String responseType = "code";
}
