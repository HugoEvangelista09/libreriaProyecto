package com.elbuenpastor.proyectoLibreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuenpastor.proyectoLibreria.model.Cliente;
import com.elbuenpastor.proyectoLibreria.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
    private ClienteRepository repo;
	
	public List<Cliente> listar(){
        return repo.findAll();
    }

    public void guardar(Cliente c){
        repo.save(c);
    }

    public Cliente buscar(Integer id){
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Integer id){
        repo.deleteById(id);
    }
	
	
}
