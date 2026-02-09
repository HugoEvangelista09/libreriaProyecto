package com.elbuenpastor.proyectoLibreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.elbuenpastor.proyectoLibreria.model.Libro;
import com.elbuenpastor.proyectoLibreria.service.LibroService;

@Controller
public class LibroController {
	
	@Autowired
	private LibroService service;
	
	@GetMapping("/app")
	public String index(Model model) {
		model.addAttribute("lista", service.listarTodos());
		model.addAttribute("libro", new Libro());
		return "libros.html";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Libro libro) {
		service.guardar(libro);
		return "redirect:/app";
	}
	
}
