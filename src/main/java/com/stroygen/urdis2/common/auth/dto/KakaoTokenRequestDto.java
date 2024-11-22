package com.stroygen.urdis2.common.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class KakaoTokenRequestDto {
    @JsonProperty("grant_type")
    private String grantType;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("redirect_uri")
    private String redirectUri;
    @JsonProperty("code")
    private String code;

    @Builder
    public KakaoTokenRequestDto(String grantType, String clientId, String clientSecret, String redirectUri, String code) {
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.code = code;
    }
}
