package com.elbuenpastor.proyectoLibreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.elbuenpastor.proyectoLibreria.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	
	
}
