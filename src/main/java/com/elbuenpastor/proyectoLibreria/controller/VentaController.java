package com.elbuenpastor.proyectoLibreria.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.elbuenpastor.proyectoLibreria.model.Venta;
import com.elbuenpastor.proyectoLibreria.service.ClienteService;
import com.elbuenpastor.proyectoLibreria.service.LibroService;
import com.elbuenpastor.proyectoLibreria.service.VentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private LibroService libroService;
    
    @Autowired
    private ClienteService clienteService;

    //LISTAR
    @GetMapping
    public String listar(Model model){
        model.addAttribute("venta", new Venta());
        model.addAttribute("listaVentas", ventaService.listar());
        model.addAttribute("listaLibros", libroService.listarTodos());
        model.addAttribute("listaClientes", clienteService.listar());
        return "ventas";
    }

    //GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Venta venta){
        ventaService.guardar(venta);
        return "redirect:/ventas";
    }

    //EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("venta", ventaService.buscar(id));
        model.addAttribute("listaVentas", ventaService.listar());
        model.addAttribute("listaLibros", libroService.listarTodos());
        model.addAttribute("listaClientes", clienteService.listar());
        return "ventas";
    }

    //ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        ventaService.eliminar(id);
        return "redirect:/ventas";
    }
}