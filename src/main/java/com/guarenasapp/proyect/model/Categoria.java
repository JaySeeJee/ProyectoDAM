package com.guarenasapp.proyect.model;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="Categorias")
public class Categoria extends BaseEntity{

	
	private String nombre;
	private String descripcion;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [descripcion=" + descripcion + ", nombre=" + nombre + "]";
	}

	

}
