package es.jamasa.tpv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.jamasa.tpv.mapper.RolMapper;
import es.jamasa.tpv.model.dto.RolDTO;
import es.jamasa.tpv.model.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	
	RolRepository repo;
	private final RolMapper rolMapper;
	public RolServiceImpl(RolRepository repo, RolMapper rolMapper) {
		this.repo = repo;
		this.rolMapper = rolMapper;
	}
	@Override
	public List<RolDTO> getList() {
		
		return repo.findAll().stream()
				.map(rolMapper::toDTO)
				.toList();
	}

}
