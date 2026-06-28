package es.jamasa.tpv.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FamiliaDTO {
	 private Long id;
	 
	 @NotBlank(message = "El nombre no puede estar vacío")
	 private String nombre;
	 @NotNull(message = "El impuesto es obligatorio")
	 private ImpuestoDTO impuesto;
	 private LocalDateTime fechaAlta;
	 private String usuarioAlta;
	 private LocalDateTime fechaModificacion;
	 private String usuarioModificacion;
	 
	 public FamiliaDTO () {}

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

	 public ImpuestoDTO getImpuesto() {
		 return impuesto;
	 }

	 public void setImpuesto(ImpuestoDTO impuesto) {
		 this.impuesto = impuesto;
	 }

	 public LocalDateTime getFechaAlta() {
		 return fechaAlta;
	 }

	 public void setFechaAlta(LocalDateTime fechaAlta) {
		 this.fechaAlta = fechaAlta;
	 }

	 public String getUsuarioAlta() {
		 return usuarioAlta;
	 }

	 public void setUsuarioAlta(String usuarioAlta) {
		 this.usuarioAlta = usuarioAlta;
	 }

	 public LocalDateTime getFechaModificacion() {
		 return fechaModificacion;
	 }

	 public void setFechaModificacion(LocalDateTime fechaModificacion) {
		 this.fechaModificacion = fechaModificacion;
	 }

	 public String getUsuarioModificacion() {
		 return usuarioModificacion;
	 }

	 public void setUsuarioModificacion(String usuarioModificacion) {
		 this.usuarioModificacion = usuarioModificacion;
	 }
	 
	 
	 
	 
}
