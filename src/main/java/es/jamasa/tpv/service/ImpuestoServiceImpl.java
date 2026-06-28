package es.jamasa.tpv.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.jamasa.tpv.mapper.ImpuestoMapper;
import es.jamasa.tpv.model.dto.ImpuestoDTO;
import es.jamasa.tpv.model.entities.Impuesto;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.repository.ImpuestoRepository;
import es.jamasa.tpv.model.util.Paginacion;

@Service
@Transactional

public class ImpuestoServiceImpl implements ImpuestoService {

	@Autowired
	ImpuestoRepository impuestoRepository;
	
	@Autowired
	ImpuestoMapper impuestoMapper;
	
	@Override
	public ImpuestoDTO get(Long id) {
		return impuestoMapper.toDto(impuestoRepository.findById(id).get());
	}

	@Override
	public Paginacion<Impuesto, ImpuestoDTO> listadoPaginado(Map<String, String> params, PageParams pageData) {
		Pageable pageable = PageRequest.of(pageData.page(), pageData.size());
		
		return construirPaginacion(impuestoRepository.findAll( pageable));
	}

	@Override
	public ImpuestoDTO grabar(ImpuestoDTO impuesto, String usuarioAlta) {
		
		Impuesto entity;
		if (impuesto.getId() == null) {
			entity = new Impuesto();
			entity.setFechaAlta(LocalDateTime.now());
			entity.setUsuarioAlta(usuarioAlta);
		}
		else {
			entity = impuestoRepository.findById(impuesto.getId()).get();
		}
		entity = impuestoMapper.toEntity(impuesto, entity);
		return impuestoMapper.toDto(impuestoRepository.save(entity));
	}

	@Override
	public List<ImpuestoDTO> lista() {
		
		return impuestoRepository.findAll().stream()
				.map(impuestoMapper :: toDto)
				.toList();
	}
	private Paginacion<Impuesto, ImpuestoDTO> construirPaginacion( Page<Impuesto> page) {
        return new Paginacion.Builder<Impuesto, ImpuestoDTO>()
                .pagina(page)
                .mapper(impuestoMapper::toDto)
                .build();
    }


}
