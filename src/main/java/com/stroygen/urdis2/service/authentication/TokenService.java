package com.stroygen.urdis2.service.authentication;

import com.stroygen.urdis2.common.provider.JwtProvider;
import com.stroygen.urdis2.dto.MemberDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenService {
    public static final String SESSION_KEY = "RefreshTokens:";
    private final RedisTemplate<String, Object> redisTemplate;
    private final JwtProvider jwtProvider;

    public String issueJwt(MemberDto memberDto, HttpServletResponse response) {
        String accessToken = jwtProvider.generateAccessToken(memberDto);
        String refreshToken = jwtProvider.generateRefreshToken(memberDto);
        setAccessTokenCookie(response, accessToken);
        saveRefreshTokenOnRedis(accessToken, refreshToken);

        response.setHeader("Authorization", "Bearer " + accessToken);

        return accessToken;
    }

    public void setAccessTokenCookie(HttpServletResponse res, String token) {
        Cookie cookie = new Cookie("accessToken", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        res.addCookie(cookie);
    }

    public void saveRefreshTokenOnRedis(String accessToken, String refreshToken) {
        redisTemplate.opsForHash().put(SESSION_KEY, accessToken, refreshToken);
    }

    public void removeRefreshToken(String accessToken) {
        if (redisTemplate.opsForHash().hasKey(SESSION_KEY, accessToken)) {
            redisTemplate.opsForHash().delete(SESSION_KEY, accessToken);
        }
    }
}
