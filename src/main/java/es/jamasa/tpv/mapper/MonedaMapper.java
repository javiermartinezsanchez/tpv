package es.jamasa.tpv.mapper;

import org.springframework.stereotype.Component;

import es.jamasa.tpv.model.dto.MonedaDTO;
import es.jamasa.tpv.model.entities.Moneda;
@Component
public class MonedaMapper {
	
		public Moneda toEntity(MonedaDTO dto) {
			Moneda entity = new Moneda();
			entity.setId(dto.getId());
			entity.setNombre(dto.getNombre());
			entity.setTexto(dto.getTexto());
			return entity;
		}
		
		public MonedaDTO toDto(Moneda entity) {
			MonedaDTO dto = new MonedaDTO();
			dto.setId(entity.getId());
			dto.setNombre(entity.getNombre());
			dto.setTexto(entity.getTexto());
			return dto;
		}
}
