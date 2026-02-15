package com.elbuenpastor.proyectoLibreria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elbuenpastor.proyectoLibreria.model.Libro;
import com.elbuenpastor.proyectoLibreria.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository repository;
	
	public List<Libro> listarTodos() {
		return repository.findAll();
	}
	
	public void guardar(Libro objLibro) {
		repository.save(objLibro);
	}
	
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	public Libro buscarPorId(Integer id) {
	    return repository.findById(id).orElse(null);
	}

}
