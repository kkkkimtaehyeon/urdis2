package com.stroygen.urdis2.common.auth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoTokenResponseDto {
    private final String tokenType;
    private final String accessToken;
    private final Integer expiresIn;
    private final String refreshToken;
    private final Integer refreshTokenExpiresIn;

    @JsonCreator
    public KakaoTokenResponseDto(
            @JsonProperty("token_type") String tokenType,
            @JsonProperty("access_token") String accessToken,
            @JsonProperty("expires_in") Integer expiresIn,
            @JsonProperty("refresh_token") String refreshToken,
            @JsonProperty("refresh_token_expires_in") Integer refreshTokenExpiresIn) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }
}
