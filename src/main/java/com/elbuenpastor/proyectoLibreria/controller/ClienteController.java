package com.elbuenpastor.proyectoLibreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elbuenpastor.proyectoLibreria.model.Cliente;
import com.elbuenpastor.proyectoLibreria.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
    private ClienteService service;
	
	// LISTAR
	@GetMapping
	public String listar(Model model){
	    model.addAttribute("lista", service.listar());
	    model.addAttribute("cliente", new Cliente()); 
	    return "clientes";
	}

    // NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente){
        service.guardar(cliente);
        return "redirect:/clientes";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("cliente", service.buscar(id));
        model.addAttribute("lista", service.listar()); 
        return "clientes";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return "redirect:/clientes";
    }
}
