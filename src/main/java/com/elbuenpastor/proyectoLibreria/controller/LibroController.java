package com.elbuenpastor.proyectoLibreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elbuenpastor.proyectoLibreria.model.Libro;
import com.elbuenpastor.proyectoLibreria.service.LibroService;

@Controller
@RequestMapping("/libros")   // Ruta base para todos los métodos
public class LibroController {
	
	@Autowired
	private LibroService service;
	
	// LISTAR
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("lista", service.listarTodos());
		model.addAttribute("libro", new Libro());
		return "libros.html";
	}
	
	// GUARDAR
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Libro libro) {
		service.guardar(libro);
		return "redirect:/libros";
	}
	
	// ELIMINAR
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return "redirect:/libros";
	}
	
	// EDITAR
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("libro", service.buscarPorId(id));
		model.addAttribute("lista", service.listarTodos());
		return "libros.html";
	}
}

