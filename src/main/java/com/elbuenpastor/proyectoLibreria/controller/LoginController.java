package com.elbuenpastor.proyectoLibreria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        // Devuelve la vista login.html ubicada en src/main/resources/templates/
        return "login";
    }
}
