package com.grupo5.grupo5.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class PrivateController {
    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("nombreFull", principal.getName());
        return "home";
    }

    @GetMapping("/admin/add")
    @PreAuthorize("hasRole('admin')")
    public String addSecretarias() {
        return "secretarias";
    }

}
