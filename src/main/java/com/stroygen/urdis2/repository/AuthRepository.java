package com.stroygen.urdis2.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AuthRepository {
    private final RedisTemplate<String, Object> sessionRedisTemplate;
    private static final String LOGIN_SESSION_KEY = "LoginSession:";

    public void save(String sessionId, String email) {
        sessionRedisTemplate.opsForHash().put(LOGIN_SESSION_KEY, sessionId, email);
    }

    public void delete(String sessionId) {
        if (sessionId != null) {
            if (sessionRedisTemplate.opsForHash().hasKey(LOGIN_SESSION_KEY, sessionId)) {
                sessionRedisTemplate.opsForHash().delete(LOGIN_SESSION_KEY, sessionId);
            }
        }
    }
}
