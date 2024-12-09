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
    public static final String SESSION = "RefreshTokens:";
    private final RedisTemplate<String, Object> session;
    private final JwtProvider jwtProvider;

    public void issueJwt(MemberDto memberDto, HttpServletResponse response) {
        String accessToken = jwtProvider.generateAccessToken(memberDto);
        String refreshToken = jwtProvider.generateRefreshToken(memberDto);
        // 쿠키(or 로컬 스토리지)에 액세스 토큰 추가
        setAccessTokenCookie(response, accessToken);
        // 레디스에서 액세스토큰: 리프레시 토큰 저장
        saveRefreshTokenOnRedis(accessToken, refreshToken);

    }

    public void setAccessTokenCookie(HttpServletResponse res, String token) {
        Cookie cookie = new Cookie("accessToken", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        res.addCookie(cookie);
    }

    public void saveRefreshTokenOnRedis(String accessToken, String refreshToken) {
        session.opsForHash().put(SESSION, accessToken, refreshToken);
    }
}
