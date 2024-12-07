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
public class IndexController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) throws IOException {
        if (oAuth2User != null) {
            model.addAttribute("nickname", oAuth2User.getAttribute("nickname"));
            model.addAttribute("email", oAuth2User.getAttribute("email"));
        }

        return "index";
    }
}
