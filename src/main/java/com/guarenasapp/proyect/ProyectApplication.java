package com.guarenasapp.proyect;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guarenasapp.proyect.model.Perfil;
import com.guarenasapp.proyect.repository.PerfilesRepository;

@SpringBootApplication
public class ProyectApplication {

	private PerfilesRepository repoPerfiles;
	public static void main(String[] args) {
		SpringApplication.run(ProyectApplication.class, args);
	}

	public void run(String... args) throws Exception {
		crearPerfilesAplicacion();
	}

	private void crearPerfilesAplicacion() {
		repoPerfiles.saveAll(getPerfilesAplicacion());
	}



	private List<Perfil> getPerfilesAplicacion() {
		List<Perfil> lista = new LinkedList<Perfil>();
		Perfil perfil1 = new Perfil();
		perfil1.setPerfil("SUPERVISOR");

		Perfil perfil2 = new Perfil();
		perfil2.setPerfil("ADMINISTRADOR");

		Perfil perfil3 = new Perfil();
		perfil3.setPerfil("USUARIO");


		lista.add(perfil1);
		lista.add(perfil2);
		lista.add(perfil3);

		return lista;

		
	}


}
