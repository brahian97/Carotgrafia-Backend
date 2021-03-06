package com.amapearte.modelo;
// Generated 5/08/2017 04:28:14 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Lugar generated by hbm2java
 */
@Entity
@Table(name = "lugar", schema = "public")
public class Lugar implements java.io.Serializable {
	@NotNull(message="El descestado es obligatorio")	
	private int idlugar;
	@NotNull(message="El descestado es obligatorio")
	@Size(min = 1,max=255,message="Minimo de caracteres es 1 y maximo 255 nombrelugar")
	private String nombrelugar;
	@NotNull(message="El desclugar es obligatorio")
	@Size(min = 1,max=100,message="Minimo de caracteres es 1 desclugar")
	private String desclugar;
	@NotNull(message="La longitud es obligatorio")	
	private double longitud;
	@NotNull(message="La latitud es obligatorio")	
	private double latitud;
		
	private int megustavotos;
	private int nomegustavotos;
	private int visitas;
	private Set<CategoriaLugar> categoriaLugars = new HashSet<CategoriaLugar>(0);
	private Set<TipoLugarLugar> tipoLugarLugars = new HashSet<TipoLugarLugar>(0);
	private Set<SoporteLugar> soporteLugars = new HashSet<SoporteLugar>(0);
	private Set<CapaLugar> capaLugars = new HashSet<CapaLugar>(0);

	public Lugar() {
	}

	public Lugar(int idlugar, String nombrelugar, String desclugar, double longitud, double latitud, int megustavotos,
			int nomegustavotos, int visitas) {
		this.idlugar = idlugar;
		this.nombrelugar = nombrelugar;
		this.desclugar = desclugar;
		this.longitud = longitud;
		this.latitud = latitud;
		this.megustavotos = megustavotos;
		this.nomegustavotos = nomegustavotos;
		this.visitas = visitas;
	}

	public Lugar(int idlugar, String nombrelugar, String desclugar, double longitud, double latitud, int megustavotos,
			int nomegustavotos, int visitas, Set<CategoriaLugar> categoriaLugars, Set<TipoLugarLugar> tipoLugarLugars,
			Set<SoporteLugar> soporteLugars, Set<CapaLugar> capaLugars) {
		this.idlugar = idlugar;
		this.nombrelugar = nombrelugar;
		this.desclugar = desclugar;
		this.longitud = longitud;
		this.latitud = latitud;
		this.megustavotos = megustavotos;
		this.nomegustavotos = nomegustavotos;
		this.visitas = visitas;
		this.categoriaLugars = categoriaLugars;
		this.tipoLugarLugars = tipoLugarLugars;
		this.soporteLugars = soporteLugars;
		this.capaLugars = capaLugars;
	}

	@Id

	@Column(name = "idlugar", unique = true, nullable = false)
	public int getIdlugar() {
		return this.idlugar;
	}

	public void setIdlugar(int idlugar) {
		this.idlugar = idlugar;
	}

	@Column(name = "nombrelugar", nullable = false)
	public String getNombrelugar() {
		return this.nombrelugar;
	}

	public void setNombrelugar(String nombrelugar) {
		this.nombrelugar = nombrelugar;
	}

	@Column(name = "desclugar", nullable = false)
	public String getDesclugar() {
		return this.desclugar;
	}

	public void setDesclugar(String desclugar) {
		this.desclugar = desclugar;
	}

	@Column(name = "longitud", nullable = false, precision = 17, scale = 17)
	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Column(name = "latitud", nullable = false, precision = 17, scale = 17)
	public double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Column(name = "megustavotos", nullable = false)
	public int getMegustavotos() {
		return this.megustavotos;
	}

	public void setMegustavotos(int megustavotos) {
		this.megustavotos = megustavotos;
	}

	@Column(name = "nomegustavotos", nullable = false)
	public int getNomegustavotos() {
		return this.nomegustavotos;
	}

	public void setNomegustavotos(int nomegustavotos) {
		this.nomegustavotos = nomegustavotos;
	}

	@Column(name = "visitas", nullable = false)
	public int getVisitas() {
		return this.visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lugar")
	public Set<CategoriaLugar> getCategoriaLugars() {
		return this.categoriaLugars;
	}

	public void setCategoriaLugars(Set<CategoriaLugar> categoriaLugars) {
		this.categoriaLugars = categoriaLugars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lugar")
	public Set<TipoLugarLugar> getTipoLugarLugars() {
		return this.tipoLugarLugars;
	}

	public void setTipoLugarLugars(Set<TipoLugarLugar> tipoLugarLugars) {
		this.tipoLugarLugars = tipoLugarLugars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lugar")
	public Set<SoporteLugar> getSoporteLugars() {
		return this.soporteLugars;
	}

	public void setSoporteLugars(Set<SoporteLugar> soporteLugars) {
		this.soporteLugars = soporteLugars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lugar")
	public Set<CapaLugar> getCapaLugars() {
		return this.capaLugars;
	}

	public void setCapaLugars(Set<CapaLugar> capaLugars) {
		this.capaLugars = capaLugars;
	}

}
