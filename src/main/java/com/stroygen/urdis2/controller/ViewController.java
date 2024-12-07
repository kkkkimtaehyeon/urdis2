package com.stroygen.urdis2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/members/register")
    public String registerPage(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        return "registration";
    }
}
