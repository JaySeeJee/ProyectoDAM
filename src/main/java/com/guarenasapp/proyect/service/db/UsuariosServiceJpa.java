package com.guarenasapp.proyect.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guarenasapp.proyect.model.Usuario;
import com.guarenasapp.proyect.repository.UsuariosRepository;
import com.guarenasapp.proyect.service.IUsuariosService;


@Service
public class UsuariosServiceJpa implements IUsuariosService {


    @Autowired
	private UsuariosRepository usuariosRepo;

	public List<Usuario> buscarTodas() {		
		return usuariosRepo.findAll();
	}

	public Usuario buscarPorId(Integer idUsuario) {
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);		
	}

	@Override
	public Page<Usuario> buscarTodas(Pageable page) {		
		return usuariosRepo.findAll(page);
	}

    
}
