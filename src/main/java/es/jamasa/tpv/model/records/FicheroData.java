package es.jamasa.tpv.model.records;

public record FicheroData(
		int indice,
	    String nombreOriginal,
	    String contentType,
	    byte[] contenido
	) {}
