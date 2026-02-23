package com.elbuenpastor.proyectoLibreria.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.elbuenpastor.proyectoLibreria.model.Venta;
import com.elbuenpastor.proyectoLibreria.service.VentaService;

@Controller
public class ReporteController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/reportes")
    public String mostrarFormulario() {
        return "reportes";
    }

    @PostMapping("/reportes")
    public String generarReporte(@RequestParam String inicio,
                                 @RequestParam String fin,
                                 Model model) {

        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);

        List<Venta> filtradas = ventaService.listarVentasPorRango(fechaInicio, fechaFin);

        model.addAttribute("listaVentas", filtradas);
        return "reportes";
    }
}
