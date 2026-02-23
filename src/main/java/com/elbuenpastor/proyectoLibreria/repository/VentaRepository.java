package com.elbuenpastor.proyectoLibreria.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elbuenpastor.proyectoLibreria.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
