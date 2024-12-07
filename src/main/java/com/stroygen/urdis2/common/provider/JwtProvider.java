package com.stroygen.urdis2.common.provider;


import com.stroygen.urdis2.dto.MemberDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {
    @Value("${token.access-expired-time}")
    private long ACCESS_EXPIRED_TIME;

    @Value("${token.refresh-expired-time}")
    private long REFRESH_EXPIRED_TIME;

    @Value("${token.secret}")
    private String SECRET;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(MemberDto memberDto) {
        return Jwts.builder()
                .subject(String.valueOf(memberDto.getId()))
                .claim("email", memberDto.getEmail())
                .claim("role", memberDto.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRED_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    public String generateRefreshToken(MemberDto memberDto) {
        return Jwts.builder()
                .subject(String.valueOf(memberDto.getId()))
                .claim("email", memberDto.getEmail())
                .claim("role", memberDto.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRED_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(this.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
