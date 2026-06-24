package es.jamasa.tpv.model.records;

import es.jamasa.tpv.model.entities.TipoFichero;

/**
 * Estructura para la administración de espacio.
 * <p>Identificamos el nombre, tamaño, el Tipo y si es huérfano (ha perdido su relacióno con nuestras entidades)
 */
public record ArchivoFisicoDTO(
	    String nombre,
	    String nombreReal,
	    String sizeKB,
	    boolean esHuerfano,
	    TipoFichero tipoFichero
	) {}
