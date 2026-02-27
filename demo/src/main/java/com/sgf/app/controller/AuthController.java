package com.sgf.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.sgf.app.service.UserService;

@Controller
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(String email, String username, String password) {
        service.register(email, username, password);
        return "redirect:/login";
    }
}