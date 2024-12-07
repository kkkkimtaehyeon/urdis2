package com.stroygen.urdis2.common.handler;

import com.stroygen.urdis2.common.provider.JwtProvider;
import com.stroygen.urdis2.dto.MemberDto;
import com.stroygen.urdis2.exception.MemberNotFoundException;
import com.stroygen.urdis2.service.MemberService;
import com.stroygen.urdis2.service.authentication.AuthService;
import com.stroygen.urdis2.service.authentication.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final MemberService memberService;
    private final JwtProvider jwtProvider;
    private final TokenService tokenService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        // 등록된 유저인지 확인
//        MemberDto memberDto = new MemberDto(1L, email, "ROLE_ADMIN");
        try {
            MemberDto memberDto = memberService.getMember(email);

            String accessToken = jwtProvider.generateAccessToken(memberDto);
            String refreshToken = jwtProvider.generateRefreshToken(memberDto);
            // 쿠키(or 로컬 스토리지)에 액세스 토큰 추가
            tokenService.setAccessTokenCookie(response, accessToken);
            // 레디스에서 액세스토큰: 리프레시 토큰 저장
            tokenService.saveRefreshTokenOnRedis(accessToken, refreshToken);

        } catch (MemberNotFoundException e) {
            response.sendRedirect("/members/register?email=" + email);
            return;
        }

    }
}
