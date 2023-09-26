package com.example.springsecurity.controller;

import com.example.springsecurity.service.UserService;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Builder
public class MainController {
     UserService userService;




    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("users", userService.getAll());
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
