package com.elbuenpastor.proyectoLibreria.model;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="tblVentas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    private LocalDate fecha;

    private Double total;

    @ManyToOne
    @JoinColumn(name="idCliente") // FK CLIENTE
    private Cliente cliente;

    
	public Venta() {
	
	}


	public Venta(Integer idVenta, LocalDate fecha, Double total, Cliente cliente) {
		
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
	}


	public Integer getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    
}