package com.guarenasapp.proyect.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guarenasapp.proyect.model.Vacante;
import com.guarenasapp.proyect.repository.VacantesRepository;
import com.guarenasapp.proyect.service.IVacantesService;



@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {
	
	@Autowired
	private VacantesRepository vacantesRepo;

	public List<Vacante> buscarTodas() {		
		return vacantesRepo.findAll();
	}

	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = vacantesRepo.findById(idVacante);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void guardar(Vacante vacante) {
		vacantesRepo.save(vacante);
	}

	public List<Vacante> buscarDestacadas() {
		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	public void eliminar(Integer idVacante) {
		vacantesRepo.deleteById(idVacante);		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		return vacantesRepo.findAll(example);
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {		
		return vacantesRepo.findAll(page);
	}

}
