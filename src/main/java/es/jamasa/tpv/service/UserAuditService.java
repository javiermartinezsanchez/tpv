package es.jamasa.tpv.service;

import java.util.List;
import java.util.Map;

import es.jamasa.tpv.model.dto.AccesoPorDia;
import es.jamasa.tpv.model.dto.UserAuditDTO;
import es.jamasa.tpv.model.entities.UserAudit;
import es.jamasa.tpv.model.records.PageParams;
import es.jamasa.tpv.model.util.Paginacion;

public interface UserAuditService {

	public Paginacion<UserAudit, UserAuditDTO> listadoPaginado(  PageParams pageable,
			Map<String, String> params);

	/**
	 * Se obtiene el listado de días y número de acceso entre fechas.
	 * @return
	 */
	public List<AccesoPorDia> contarAccesosPorDia(Map<String, String> params);

}
