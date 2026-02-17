package com.elbuenpastor.proyectoLibreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuenpastor.proyectoLibreria.model.DetalleVenta;
import com.elbuenpastor.proyectoLibreria.model.Libro;
import com.elbuenpastor.proyectoLibreria.model.Venta;
import com.elbuenpastor.proyectoLibreria.repository.DetalleVentaRepository;
import com.elbuenpastor.proyectoLibreria.repository.VentaRepository;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private LibroService libroService;
    
    @Autowired
    private VentaRepository ventaRepository;

    public List<DetalleVenta> listar(){
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta guardar(DetalleVenta detalle){

        
        Libro libro = libroService.buscarPorId(
                detalle.getLibro().getIdLibro()
        );

        if(libro == null){
            throw new RuntimeException("Libro no encontrado");
        }

        
        detalle.setPrecio(libro.getPrecio());

        
        double subtotal = detalle.getCantidad() * libro.getPrecio();
        detalle.setSubtotal(subtotal);

        
        libro.setStock(libro.getStock() - detalle.getCantidad());
        libroService.guardar(libro);
        
        Venta venta = detalle.getVenta();
        
        if(venta.getTotal() == null){
            venta.setTotal(0.0);
        }

        venta.setTotal(venta.getTotal() + subtotal);

        ventaRepository.save(venta);

        return detalleVentaRepository.save(detalle);
    }

    public DetalleVenta buscar(Integer id){
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id){
        detalleVentaRepository.deleteById(id);
    }
}
