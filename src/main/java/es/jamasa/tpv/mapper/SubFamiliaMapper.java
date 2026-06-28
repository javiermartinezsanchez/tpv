package es.jamasa.tpv.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import es.jamasa.tpv.model.dto.SubFamiliaDTO;
import es.jamasa.tpv.model.entities.Familia;
import es.jamasa.tpv.model.entities.SubFamilia;

@Component
public class SubFamiliaMapper {

	public SubFamiliaDTO toDTO(SubFamilia entity) {
		SubFamiliaDTO dto = new SubFamiliaDTO();
		dto.setId( entity.getId()) ;
		dto.setNombre(entity.getNombre());
		dto.setFechaAlta(entity.getFechaAlta());
		dto.setUsuarioAlta(entity.getUsuarioAlta());
		
		return dto;
	}
	public SubFamilia toEntity(SubFamiliaDTO dto, SubFamilia entity) {
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setFechaModificacion(LocalDateTime.now() );
		entity.setUsuarioModificacion(dto.getUsuarioModificacion());
		return entity;
	}
}
