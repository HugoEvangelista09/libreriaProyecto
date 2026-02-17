package com.elbuenpastor.proyectoLibreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elbuenpastor.proyectoLibreria.model.DetalleVenta;
import com.elbuenpastor.proyectoLibreria.service.DetalleVentaService;
import com.elbuenpastor.proyectoLibreria.service.LibroService;
import com.elbuenpastor.proyectoLibreria.service.VentaService;

@Controller
@RequestMapping("/detalleventa")
public class DetalleVentaController {

	@Autowired
    private DetalleVentaService detalleVentaService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private LibroService libroService;
    
 // ✅ LISTAR
    @GetMapping
    public String listar(Model model){
        model.addAttribute("detalleVenta", new DetalleVenta());
        model.addAttribute("listaDetalles", detalleVentaService.listar());
        model.addAttribute("listaVentas", ventaService.listar());
        model.addAttribute("listaLibros", libroService.listarTodos());
        return "detalleVenta";
    }

    // ✅ GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetalleVenta detalle){
        detalleVentaService.guardar(detalle);
        return "redirect:/detalleventa";
    }

    //EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("detalle", detalleVentaService.buscar(id));
        model.addAttribute("listaDetalles", detalleVentaService.listar());
        model.addAttribute("listaVentas", ventaService.listar());
        model.addAttribute("listaLibros", libroService.listarTodos());
        return "detalleVenta";
    }

    // ✅ ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        detalleVentaService.eliminar(id);
        return "redirect:/detalleventa";
    }

}
