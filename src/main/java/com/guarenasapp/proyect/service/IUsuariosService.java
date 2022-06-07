package com.guarenasapp.proyect.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.guarenasapp.proyect.model.Usuario;



public interface IUsuariosService {
	List<Usuario> buscarTodas();
	Usuario buscarPorId(Integer idUsuario);
	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	Page<Usuario>buscarTodas(Pageable page);
}
