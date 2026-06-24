package es.jamasa.tpv.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.jamasa.tpv.dto.MonedaDTO;
import es.jamasa.tpv.model.entities.Moneda;
import es.jamasa.tpv.mapper.MonedaMapper;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.repository.MonedaRepository;
import es.jamasa.tpv.model.util.Paginacion;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class MonedaServiceImpl implements MonedaService {

	@Autowired
	MonedaMapper monedaMapper;
	
	@Autowired
	MonedaRepository monedaRepository;
	
	@Override
	public Paginacion<Moneda, MonedaDTO> listadoPaginado(PageParams pageData, Map<String, String> params) {
		Pageable pageable = PageRequest.of(pageData.page(), pageData.size());
		return new Paginacion.Builder<Moneda, MonedaDTO>()
				.pagina(monedaRepository.findAll(pageable))
				.mapper(monedaMapper::toDto)
				.build();
	}

	@Override
	public MonedaDTO grabar(MonedaDTO dto, String userName) {
		Moneda moneda = monedaMapper.toEntity(dto);
		if (dto.getId() == null) {
			
		}
		return monedaMapper.toDto(monedaRepository.save(moneda));
	}

	@Override
	public MonedaDTO get(Long id) {
		return monedaMapper.toDto(monedaRepository.findById(id).get());
	}

}
