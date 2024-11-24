package com.stroygen.urdis2.service.authentication;

import com.stroygen.urdis2.exception.LogoutFailException;
import com.stroygen.urdis2.repository.AuthRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private static final String SESSION_KEY = "SESSIONID";

    public void addOAuth2UserOnSession(HttpServletRequest req, HttpServletResponse res, Authentication authentication) {
        String sessionId = UUID.randomUUID().toString();
        try {
            OAuth2User oAuth2User = addSessionCookie(sessionId, res, authentication);
            String email = oAuth2User.getAttribute("email");
            if (email != null) {
                authRepository.save(sessionId, email);
                log.info(String.format("LoginSession:%s:%s 등록", sessionId, email));
            }
        } catch (Exception e) {
            removeOAuth2UserOnSession(req, res);
        }
    }

    public void removeOAuth2UserOnSession(HttpServletRequest req, HttpServletResponse res) {
        String sessionId = removeSessionCookie(req, res);
        if (sessionId != null) {
            authRepository.delete(sessionId);
        } else {
            throw new LogoutFailException();
        }
    }

    private OAuth2User addSessionCookie(String sessionId, HttpServletResponse res, Authentication authentication) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Cookie cookie = new Cookie(SESSION_KEY, sessionId);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);
        res.addCookie(cookie);

        return oAuth2User;
    }

    private String removeSessionCookie(HttpServletRequest req, HttpServletResponse res) {
        Cookie[] cookies = req.getCookies();
        String sessionId = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(SESSION_KEY)) {
                sessionId = cookie.getValue();
                cookie.setMaxAge(0);
                res.addCookie(cookie);
                break;
            }
        }
        return sessionId;
    }
}
