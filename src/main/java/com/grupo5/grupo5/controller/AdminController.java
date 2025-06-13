package com.grupo5.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo5.grupo5.entity.Usuario;
import com.grupo5.grupo5.service.SecretariaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user/admin")
@PreAuthorize("hasRole('admin')")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private SecretariaService service;

    @GetMapping("/secretarias")
    public String getSecretarias(Model model) {
        model.addAttribute("secretarias", this.service.findAll());
        return "secretarias";
    }

    @PostMapping("/secretaria")
    public String createSecretarias(@ModelAttribute Usuario usuario) {
        usuario.setRole("ROLE_secretaria");
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        this.service.save(usuario);
        return "redirect:/user/admin/secretarias";
    }

    @GetMapping("/buscar")
    public String buscarPorEmail(@RequestParam("email") String email, Model model) {
        Usuario secretaria = this.service.getByEmail(email).orElse(null);

        if (secretaria != null) {
            model.addAttribute("secretarias", List.of(secretaria));
        } else {
            model.addAttribute("secretarias", List.of());
            model.addAttribute("mensaje", "No se encontró secretaria con la cédula: " + email);
        }

        return "secretarias";
    }
}
