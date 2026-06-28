package es.jamasa.tpv.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.jamasa.tpv.mapper.FamiliaMapper;
import es.jamasa.tpv.model.dto.FamiliaDTO;
import es.jamasa.tpv.model.entities.Familia;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.repository.FamiliaRepository;
import es.jamasa.tpv.model.util.Paginacion;
@Service
@Transactional
public class FamiliaServiceImpl implements FamiliaService {

	@Autowired
	FamiliaRepository familiaRepository;
	
	@Autowired
	FamiliaMapper familiaMapper;
	
	@Override
	public Paginacion<Familia, FamiliaDTO> listadoPaginado(Map<String, String> params, PageParams pageData) {
		Pageable pageable = PageRequest.of(pageData.page(), pageData.size());
		return construirPaginacion(familiaRepository.findAll(pageable));
	}

	private Paginacion<Familia, FamiliaDTO> construirPaginacion (Page<Familia> page){
		return new Paginacion.Builder<Familia, FamiliaDTO>()
				.pagina(page)
				.mapper(familiaMapper::toDTO)
				.build();
	}
	@Override
	public FamiliaDTO grabar(FamiliaDTO dto, String usuarioAlta) {
		
		Familia entity;
		if (dto.getId() == null) {
			entity= new Familia();
			entity.setFechaAlta(LocalDateTime.now());
			entity.setUsuarioAlta(usuarioAlta);
			
		}
		else {
			entity = familiaRepository.findById(dto.getId()).get();
		}
		entity = familiaMapper.toEntity(dto, entity);
		return familiaMapper.toDTO(familiaRepository.save(entity));
	}

	@Override
	public @Nullable FamiliaDTO get(Long id) {
		return familiaMapper.toDTO(familiaRepository.findById(id).get());
	}

}
