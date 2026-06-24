package es.jamasa.tpv.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.jamasa.tpv.dto.SubFamiliaDTO;
import es.jamasa.tpv.mapper.SubFamiliaMapper;
import es.jamasa.tpv.model.entities.SubFamilia;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.repository.SubFamiliaRepository;
import es.jamasa.tpv.model.util.Paginacion;
@Service
public class SubFamiliaServiceImpl implements SubFamiliaService {

	@Autowired 
	SubFamiliaMapper subFamiliaMapper;
	
	@Autowired
	SubFamiliaRepository subFamiliaRepository;
	
	@Override
	public Paginacion<SubFamilia, SubFamiliaDTO> listadoPaginado(Map<String, String> params, PageParams pageData) {
		Pageable pageable = PageRequest.of(pageData.page(), pageData.size());
		return construirPaginacion(subFamiliaRepository.findAll(pageable));
	}

	private Paginacion<SubFamilia, SubFamiliaDTO> construirPaginacion(Page<SubFamilia> page){
	return new Paginacion.Builder<SubFamilia, SubFamiliaDTO>()
			.pagina(page)
			.mapper(subFamiliaMapper :: toDTO)
			.build();
	}

	@Override
	public SubFamiliaDTO grabar(SubFamiliaDTO dto, String usuario) {
		SubFamilia entity;
		if (dto.getId() == null) {
			entity = new SubFamilia();
			entity.setFechaAlta(LocalDateTime.now());
			entity.setUsuarioAlta(usuario);
		}
		else {
			entity = subFamiliaRepository.findById(dto.getId()).get();
			entity.setFechaModificacion(LocalDateTime.now());
			entity.setUsuarioModificacion(usuario);
		}
		entity = subFamiliaMapper.toEntity(dto, entity);
		return subFamiliaMapper.toDTO(subFamiliaRepository.save(entity));
	}

	@Override
	public SubFamiliaDTO get(Long id) {
		return subFamiliaMapper.toDTO(subFamiliaRepository.findById(id).get());
	}

}