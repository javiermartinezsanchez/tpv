package es.jamasa.tpv.service;

import java.util.List;

import es.jamasa.tpv.dto.RolDTO;

/**
 * Clase service del modelo de negocio para la entidad {@code Rol}
 */
public interface RolService {
	/**
	 * Devolvemos el listado de rol {@code RolDTO}
	 * @return Listado
	 */
	List<RolDTO> getList();
}
