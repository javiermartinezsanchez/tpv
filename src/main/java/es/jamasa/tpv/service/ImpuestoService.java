package es.jamasa.tpv.service;

import java.util.List;
import java.util.Map;

import es.jamasa.tpv.dto.ImpuestoDTO;
import es.jamasa.tpv.model.entities.Impuesto;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.util.Paginacion;

public interface ImpuestoService {

	public ImpuestoDTO get(Long id);
	
	public Paginacion<Impuesto, ImpuestoDTO> listadoPaginado( Map<String, String> params, PageParams pageData);
	
	public ImpuestoDTO grabar(ImpuestoDTO impuesto, String usuarioAlta);
	
	public List<ImpuestoDTO> lista ();
}
