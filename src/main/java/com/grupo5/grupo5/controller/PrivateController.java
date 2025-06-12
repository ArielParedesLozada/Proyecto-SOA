package com.grupo5.grupo5.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/admin")
public class PrivateController {
    @GetMapping("/")
    public String home() {
        return "privateHome";
    }
    
    @GetMapping("/secretarias/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addSecretarias() {
        return "add-secretaria";
    }
    
}
