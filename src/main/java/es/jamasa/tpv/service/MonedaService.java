package es.jamasa.tpv.service;

import java.util.Map;

import es.jamasa.tpv.dto.MonedaDTO;
import es.jamasa.tpv.model.entities.Moneda;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.util.Paginacion;

public interface MonedaService {

	public Paginacion<Moneda, MonedaDTO> listadoPaginado(PageParams pageData, Map<String,String> params);
	
	public MonedaDTO grabar(MonedaDTO dto, String userName);
	
	public MonedaDTO get(Long id);
}
