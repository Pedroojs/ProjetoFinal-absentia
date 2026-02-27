package com.sgf.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.sgf.app.service.CourseService;
import com.sgf.app.model.Course;
import com.sgf.app.model.User;

@Controller
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/courses")
    public String courses(Model model,
                          @AuthenticationPrincipal User user) {

        model.addAttribute("courses",
                service.findByUser(user));

        model.addAttribute("course", new Course());
        return "courses";
    }

    @PostMapping("/courses")
    public String save(@ModelAttribute Course course,
                       @AuthenticationPrincipal User user) {

        service.save(course, user);
        return "redirect:/courses";
    }
}