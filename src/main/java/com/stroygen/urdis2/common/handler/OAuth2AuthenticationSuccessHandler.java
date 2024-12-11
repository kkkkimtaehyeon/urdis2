package com.stroygen.urdis2.common.handler;

import com.stroygen.urdis2.dto.MemberDto;
import com.stroygen.urdis2.exception.MemberNotFoundException;
import com.stroygen.urdis2.service.MemberService;
import com.stroygen.urdis2.service.authentication.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final MemberService memberService;

    private final TokenService tokenService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        try {
            MemberDto memberDto = memberService.getMember(email);
            tokenService.issueJwt(memberDto, response);

        } catch (MemberNotFoundException e) {
            response.sendRedirect("/members/register?email=" + email);
        }
        response.sendRedirect("/");

    }
}
