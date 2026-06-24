package es.jamasa.tpv.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import es.jamasa.tpv.model.entities.TipoImpuesto;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ImpuestoDTO {

    private Long id; 
    @NotNull(message = "El tipo de impuesto es obligatorio")
    private TipoImpuesto tipo;

    @NotBlank(message = "El nombre del impuesto no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
    private String nombre;

    @NotNull(message = "El porcentaje es obligatorio")
    @DecimalMin(value = "0.0", message = "El porcentaje mínimo es 0.0")
    @DecimalMax(value = "100.0", message = "El porcentaje máximo es 100.0")
    @Digits(integer = 2, fraction = 1, message = "Formato inválido (máximo 2 enteros y 1 decimal)")
    private BigDecimal p100;

    @NotNull(message = "La fecha inicial es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIni;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;

    
    public ImpuestoDTO() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoImpuesto getTipo() { return tipo; }
    public void setTipo(TipoImpuesto tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getP100() { return p100; }
    public void setP100(BigDecimal p100) { this.p100 = p100; }

    public LocalDate getFechaIni() { return fechaIni; }
    public void setFechaIni(LocalDate fechaIni) { this.fechaIni = fechaIni; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
