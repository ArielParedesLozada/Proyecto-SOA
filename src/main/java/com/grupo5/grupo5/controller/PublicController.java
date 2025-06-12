package com.grupo5.grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {
    @GetMapping("/login")
    public String login() {
        return "index";
    }
}
