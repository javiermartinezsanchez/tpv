package es.jamasa.tpv.service;

import java.util.List;

public interface CodeBarWriterService {

	public void genCodeBarEAN13(String codigoAGenerar);
	
	public List<String> genCodeBarEAN12Base64(List<String> codigoAGenerar);
}
