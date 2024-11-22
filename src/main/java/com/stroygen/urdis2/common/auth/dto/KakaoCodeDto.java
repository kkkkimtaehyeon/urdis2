package com.stroygen.urdis2.common.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoCodeDto {
    private String code;
    public KakaoCodeDto(@JsonProperty("code") String code) {
        this.code = code;
    }
}
