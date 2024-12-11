package com.stroygen.urdis2.common.handler;

import com.stroygen.urdis2.service.authentication.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomLogoutHandler implements LogoutHandler {
    private final TokenService tokenService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("accessToken")) {
                String accessToken = cookie.getValue();
                tokenService.removeRefreshToken(accessToken);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
    }


}
