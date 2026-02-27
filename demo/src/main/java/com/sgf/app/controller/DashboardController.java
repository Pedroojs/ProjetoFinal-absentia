package com.sgf.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

import com.sgf.app.service.CourseService;
import com.sgf.app.model.User;

@Controller
public class DashboardController {

    private final CourseService service;

    public DashboardController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model,
                            @AuthenticationPrincipal User user) {

        model.addAttribute("courses",
                service.findByUser(user));

        return "dashboard";
    }
}