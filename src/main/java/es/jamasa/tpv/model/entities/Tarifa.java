package es.jamasa.tpv.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TARIFAS")
public class Tarifa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
    @Column(name = "PORCENTAJE_DESCUENTO", precision = 2, scale = 1)
	private BigDecimal p100; //Porcentaje del descuento de la tarifa

    
    @Column(name = "fecha_alta", nullable = false, updatable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "usuario_alta", nullable = false, updatable = false, length = 50)
    private String usuarioAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuario_modificacion", length = 50)
    private String usuarioModificacion;

    
    @OneToMany(mappedBy = "tarifa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cliente> clientes = new ArrayList<>();

    
    public Tarifa() {}
    
    public Tarifa(String nombre, BigDecimal p100, String usuarioAlta) {
		super();
		this.nombre = nombre;
		this.p100 = p100;
		this.fechaAlta = LocalDateTime.now();;
		this.usuarioAlta = usuarioAlta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getP100() {
		return p100;
	}

	public void setP100(BigDecimal p100) {
		this.p100 = p100;
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

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.setTarifa(this);
    }

    public void removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
        cliente.setTarifa(null);
    }
    
}
