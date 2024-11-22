package com.stroygen.urdis2.common.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final RedisTemplate<String, Object> sessionRedisTemplate;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 쿠키 추가
        String sessionId = UUID.randomUUID().toString();
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Cookie cookie = new Cookie("SESSIONID", sessionId);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        // redis에 세션 등록
        String email = oAuth2User.getAttribute("email");
        assert email != null;
        sessionRedisTemplate.opsForHash().put("LoginSession:", sessionId, email);

        //TODO: 가입한 회원인지 판별 (여기서 or customOAuth2Service에서)
        log.info(String.format("LoginSession:%s:%s 등록", sessionId, email));
        response.sendRedirect("/");
    }
}
