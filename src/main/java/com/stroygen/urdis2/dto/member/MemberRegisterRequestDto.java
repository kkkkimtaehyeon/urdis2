package com.stroygen.urdis2.dto.member;

import java.time.LocalDate;

public record MemberRegisterRequestDto(
        String email,
        String nickname,
        LocalDate birth
) {
}