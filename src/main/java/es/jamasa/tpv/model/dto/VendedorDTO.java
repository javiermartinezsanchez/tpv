package es.jamasa.tpv.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VendedorDTO extends UsuarioRegistroDTO {
	public VendedorDTO(String rol) {
		super.setRol(rol);
	}
    public VendedorDTO() {
    	super();
    }
	// Vendedor
    @NotBlank(message = "{validations.message.direccion.mandatory}")
    private String direccion;

    @NotBlank(message = "{validations.message.poblacion.mandatory}")
    private String poblacion;

    @NotBlank(message = "{validations.message.provincia.mandatory}")
    private String provincia;

    @Size(min = 5, max = 5, message = "{validations.message.codpostal.format}")
    private String codPostal;

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDireccion() {
		return direccion;
	}

}
