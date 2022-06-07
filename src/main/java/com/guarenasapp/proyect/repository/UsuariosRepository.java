package com.guarenasapp.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guarenasapp.proyect.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    
}
