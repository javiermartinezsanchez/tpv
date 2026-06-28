package es.jamasa.tpv.service;

import java.util.Map;

import org.jspecify.annotations.Nullable;

import es.jamasa.tpv.model.dto.FamiliaDTO;
import es.jamasa.tpv.model.entities.Familia;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.util.Paginacion;

public interface FamiliaService {

	public Paginacion<Familia, FamiliaDTO> listadoPaginado(Map<String, String> params, PageParams pageData);
	
	public FamiliaDTO grabar(FamiliaDTO dto, String usuarioAlta);

	public @Nullable Object get(Long id);
	
	
}
