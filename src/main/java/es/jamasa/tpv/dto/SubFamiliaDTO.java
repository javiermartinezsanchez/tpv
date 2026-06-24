package es.jamasa.tpv.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class SubFamiliaDTO {
	   private Long id;
	   @NotBlank(message = "El nombre no puede estar vacío")
	   private String nombre;
	   private LocalDateTime fechaAlta;
       private String usuarioAlta;
       private LocalDateTime fechaModificacion;
       private String usuarioModificacion;
	   public SubFamiliaDTO() { }
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
