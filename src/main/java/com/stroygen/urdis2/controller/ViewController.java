package com.stroygen.urdis2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
        if (oAuth2User != null) {
            model.addAttribute("nickname", oAuth2User.getAttribute("nickname"));
            model.addAttribute("email", oAuth2User.getAttribute("email"));
        }

        return "index";
    }

    @GetMapping("/members/register")
    public String registerPage(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        return "registration";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
