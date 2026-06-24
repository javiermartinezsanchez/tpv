package es.jamasa.tpv.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TPV_CONFIGURACION")
public class TpvConfiguracion {

	@Id
    @Column(name="NOMBRE_FISCAL", nullable = false, length = 150)
    private String nombre;
	
    @Column(name="NOMBRE_SOCIAL", length = 255)
	private String nombreSocial;
	
    @Column(name="DIRECCION", length = 255)
	private String direccion;

    @Column(name="POBLACION", length = 100)
    private String poblacion;

    @Column(name="PROVINCIA", length = 100)
    private String provincia;

    @Column(name = "COD_POSTAL", length = 5)
    private String codPostal;
	
	@Column(name = "CIF_NIF", nullable = false, length = 20)
	private String cifNif;

	@Column(name = "CTA_BANCARIA")
	private String ctaBanco;
	
	@Column(name = "TELEFONO_FIJO", length = 20)
	private String telefonoFijo;

	@Column(name = "TELEFONO_MOVIL", length = 20)
	private String telefonoMovil;

	@Column(name="NUMERO_FAX", length = 20)
	private String fax;

    @Column(name="E-MAIL", length = 100)
	private String email;

	@Column(name="WEB", length = 100)
	private String web;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_impuesto",
	   foreignKey = @ForeignKey(name = "fk_tpv_impuesto"))
    private Impuesto impuesto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda",
	   foreignKey = @ForeignKey(name = "fk_tpv_moneda"))
    private Moneda moneda;

	public TpvConfiguracion() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreSocial() {
		return nombreSocial;
	}

	public void setNombreSocial(String nombreSocial) {
		this.nombreSocial = nombreSocial;
	}

	public String getDireccion() {
		return direccion;
	}

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

	public String getCifNif() {
		return cifNif;
	}

	public void setCifNif(String cifNif) {
		this.cifNif = cifNif;
	}

	public String getCtaBanco() {
		return ctaBanco;
	}

	public void setCtaBanco(String ctaBanco) {
		this.ctaBanco = ctaBanco;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Impuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
	
}
