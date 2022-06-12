package com.guarenasapp.proyect.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Perfiles")
public class Perfil extends BaseEntity{


	private String perfil;

	

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Perfil [perfil=" + perfil + "]";
	}

	

}
