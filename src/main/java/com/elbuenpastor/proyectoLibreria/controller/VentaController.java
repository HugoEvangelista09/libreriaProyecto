package com.elbuenpastor.proyectoLibreria.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.elbuenpastor.proyectoLibreria.service.LibroService;
import com.elbuenpastor.proyectoLibreria.service.VentaService;

@Controller
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private LibroService libroService;

    @GetMapping("/ventas")
    public String ventas(Model model){
        model.addAttribute("listaLibros", libroService.listarTodos());
        model.addAttribute("listaVentas", ventaService.listarVentas());
        return "ventas.html";
    }

    @PostMapping("/vender")
    public String vender(@RequestParam Integer idLibro,
                         @RequestParam Integer cantidad){

        ventaService.registrarVenta(idLibro, cantidad);
        return "redirect:/ventas";
    }
}