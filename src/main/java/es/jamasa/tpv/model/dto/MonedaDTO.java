package es.jamasa.tpv.model.dto;

import jakarta.validation.constraints.NotBlank;

public class MonedaDTO {

	
	
	private Long id;
	
	@NotBlank(message = "{validations.moneda.titulo.mandatory}")
	private String nombre;
	
	
	@NotBlank(message = "{validations.moneda.texto.mandatory}")
	private String texto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
}
