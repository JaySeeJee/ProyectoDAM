package com.guarenasapp.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guarenasapp.proyect.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	
}
