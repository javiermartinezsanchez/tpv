package es.jamasa.tpv.service;

import java.util.Map;

import es.jamasa.tpv.dto.SubFamiliaDTO;
import es.jamasa.tpv.model.entities.SubFamilia;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.util.Paginacion;

public interface SubFamiliaService {

	public Paginacion<SubFamilia, SubFamiliaDTO> listadoPaginado(Map<String, String> params, PageParams pageData );
	
	public SubFamiliaDTO grabar(SubFamiliaDTO dto, String usuario);
	
	public SubFamiliaDTO get(Long id);
}
