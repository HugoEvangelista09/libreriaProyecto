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

        List<Venta> lista = ventaService.listarVentas();

        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);

        List<Venta> filtradas = lista.stream()
                .filter(v -> !v.getFecha().isBefore(fechaInicio)
                          && !v.getFecha().isAfter(fechaFin))
                .toList();

        model.addAttribute("listaVentas", filtradas);

        return "reportes";
    }
}
