package es.jamasa.tpv.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.jamasa.tpv.dto.ImpuestoDTO;
import es.jamasa.tpv.model.entities.Impuesto;
import es.jamasa.tpv.model.repository.ImpuestoRepository;

@Component
public class ImpuestoMapper {

	@Autowired
	ImpuestoRepository impuestoRepository;
	
	public ImpuestoDTO toDto(Impuesto entity) {
		ImpuestoDTO dto = new ImpuestoDTO();
		dto.setId(entity.getId());
		dto.setTipo(entity.getTipo());
		dto.setNombre(entity.getNombre());
		dto.setP100(entity.getP100());
		dto.setFechaIni(entity.getFechaIni());
		dto.setFechaFin(entity.getFechaFin());
		return dto;
	}

	public Impuesto toEntity(ImpuestoDTO impuesto, Impuesto entity) {
		if (entity == null) {
			entity = impuestoRepository.findById(impuesto.getId()).get();
		}
		entity.setId(impuesto.getId());
		entity.setTipo(impuesto.getTipo());
		entity.setNombre(impuesto.getNombre());
		entity.setP100(impuesto.getP100());
		entity.setFechaIni(impuesto.getFechaIni());
		entity.setFechaFin(impuesto.getFechaFin());

		return entity;
	}
}
