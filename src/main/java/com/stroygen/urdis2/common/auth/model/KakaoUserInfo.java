package com.stroygen.urdis2.common.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoUserInfo {
    private String nickname;
    private String email;


    public KakaoUserInfo(@JsonProperty("properties.nickname") String nickname,
                         @JsonProperty("kakao_account.email") String email) {
        this.nickname = nickname;
        this.email = email;
    }
}
