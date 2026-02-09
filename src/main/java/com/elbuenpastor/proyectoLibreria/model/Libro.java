package com.elbuenpastor.proyectoLibreria.model;

import jakarta.persistence.*;

@Entity
@Table(name="tblLibros")
public class Libro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLibro;
	private String titulo;
	private String autor;
	private String editorial;
	private Integer anio;
	private Double precio;
	private Integer stock;
	private String imagenUrl;
	private String categoria;

	public Libro() {

	}

	public Libro(Integer idLibro, String titulo, String autor, String editorial, Integer anio, Double precio,
			Integer stock, String imagenUrl, String categoria) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anio = anio;
		this.precio = precio;
		this.stock = stock;
		this.imagenUrl = imagenUrl;
		this.categoria = categoria;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
