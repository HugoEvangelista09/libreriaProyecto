package com.elbuenpastor.proyectoLibreria.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elbuenpastor.proyectoLibreria.model.Libro;
import com.elbuenpastor.proyectoLibreria.model.Venta;
import com.elbuenpastor.proyectoLibreria.repository.LibroRepository;
import com.elbuenpastor.proyectoLibreria.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<Venta> listarVentas(){
        return ventaRepository.findAll();
    }

    public void registrarVenta(Integer idLibro, Integer cantidad){

        Libro libro = libroRepository.findById(idLibro).orElse(null);

        if(libro != null && libro.getStock() >= cantidad){

            libro.setStock(libro.getStock() - cantidad);

            Venta venta = new Venta();
            venta.setLibro(libro);
            venta.setCantidad(cantidad);
            venta.setFecha(LocalDate.now());
            venta.setTotal(libro.getPrecio() * cantidad);

            ventaRepository.save(venta);
            libroRepository.save(libro);
        }
    }
}
