package es.jamasa.tpv.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.jamasa.tpv.dto.FamiliaDTO;
import es.jamasa.tpv.model.entities.Familia;
import es.jamasa.tpv.model.repository.ImpuestoRepository;

@Component
public class FamiliaMapper {

	@Autowired
	ImpuestoMapper impuestoMapper;
	
	@Autowired
	ImpuestoRepository impuestoRepository;
	
	public FamiliaDTO toDTO(Familia entity) {
		FamiliaDTO dto = new FamiliaDTO();
		
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setImpuesto(impuestoMapper.toDto(entity.getImpuesto()));
		dto.setFechaAlta(entity.getFechaAlta());
		dto.setUsuarioAlta(entity.getUsuarioAlta());
		dto.setFechaModificacion(entity.getFechaModificacion());
		dto.setUsuarioModificacion(entity.getUsuarioModificacion());
		return dto;
	}

	public Familia toEntity(FamiliaDTO dto, Familia entity) {
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setImpuesto(impuestoRepository.findById(dto.getImpuesto().getId()).get());
		entity.setFechaAlta(entity.getFechaAlta());
		entity.setUsuarioAlta(entity.getUsuarioAlta());
		
		
		return entity;
	}
}
