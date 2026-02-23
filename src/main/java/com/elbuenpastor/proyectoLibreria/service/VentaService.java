package com.elbuenpastor.proyectoLibreria.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuenpastor.proyectoLibreria.model.Venta;
import com.elbuenpastor.proyectoLibreria.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    
    

    public List<Venta> listar(){
        return ventaRepository.findAll();
    }
    
    // BUSCAR
    public Venta buscar(Integer id){
        return ventaRepository.findById(id).orElse(null);
    }


    // GUARDAR
    public Venta guardar(Venta venta){
        return ventaRepository.save(venta);
    }

    // ELIMINAR
    public void eliminar(Integer id){
        ventaRepository.deleteById(id);
    }
    


    public List<Venta> listarVentasPorRango(LocalDate inicio, LocalDate fin) {
        return ventaRepository.findByFechaBetween(inicio, fin);
    }
 }

