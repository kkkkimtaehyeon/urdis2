package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final MemberService memberService;

    @GetMapping("/login/kakao")
    public void loginKakako(HttpServletResponse response) throws IOException {
        response.sendRedirect("/oauth2/authorization/kakao");
        // /login/kakao가 호출된 프론트에 redirect할 url을 전달하고 싶은데 방법을 모르겠음

        System.out.println("로그인 성공");
    }


    @GetMapping("/login/success")
    public String loginSuccess(HttpServletResponse res, Model model,
                               @AuthenticationPrincipal OAuth2User oAuth2User) throws IOException {
        if (oAuth2User == null) {
            throw new RuntimeException("401, 잘못된 접근입니다.");
        }

        String email = oAuth2User.getAttribute("email");
        if (memberService.isExists(email)) {
            res.sendRedirect("/");
            return null;
        }
        model.addAttribute("email", email);
        return "registration";
    }
}
