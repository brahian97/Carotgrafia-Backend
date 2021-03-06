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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Capa generated by hbm2java
 */
@Entity
@Table(name = "capa", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "nombrecapa"))
public class Capa implements java.io.Serializable {
	@NotNull(message="El idcapa es obligatorio")	
	private int idcapa;
	@NotNull(message="El nombrecapa es obligatorio")
	@Size(min = 1,max=150,message="caracteres minimo 1 y maximo 150")
	private String nombrecapa;
	@NotNull(message="El descripcion es obligatorio")
	@Size(min = 1,max=255,message="caracteres minimo 1 y maximo 255")
	private String descripcioncapa;
	@NotNull(message="El nombre es obligatorio")
	@Size(min = 1,max =255,message="Maximo de caracteres 255")
	private String iconocapa;
	private Set<CapaLugar> capaLugars = new HashSet<CapaLugar>(0);

	public Capa() {
	}

	public Capa(int idcapa, String nombrecapa, String descripcioncapa, String iconocapa) {
		this.idcapa = idcapa;
		this.nombrecapa = nombrecapa;
		this.descripcioncapa = descripcioncapa;
		this.iconocapa = iconocapa;
	}

	public Capa(int idcapa, String nombrecapa, String descripcioncapa, String iconocapa, Set<CapaLugar> capaLugars) {
		this.idcapa = idcapa;
		this.nombrecapa = nombrecapa;
		this.descripcioncapa = descripcioncapa;
		this.iconocapa = iconocapa;
		this.capaLugars = capaLugars;
	}

	@Id

	@Column(name = "idcapa", unique = true, nullable = false)
	public int getIdcapa() {
		return this.idcapa;
	}

	public void setIdcapa(int idcapa) {
		this.idcapa = idcapa;
	}

	@Column(name = "nombrecapa", unique = true, nullable = false, length = 150)
	public String getNombrecapa() {
		return this.nombrecapa;
	}

	public void setNombrecapa(String nombrecapa) {
		this.nombrecapa = nombrecapa;
	}

	@Column(name = "descripcioncapa", nullable = false)
	public String getDescripcioncapa() {
		return this.descripcioncapa;
	}

	public void setDescripcioncapa(String descripcioncapa) {
		this.descripcioncapa = descripcioncapa;
	}

	@Column(name = "iconocapa", nullable = false)
	public String getIconocapa() {
		return this.iconocapa;
	}

	public void setIconocapa(String iconocapa) {
		this.iconocapa = iconocapa;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "capa")
	public Set<CapaLugar> getCapaLugars() {
		return this.capaLugars;
	}

	public void setCapaLugars(Set<CapaLugar> capaLugars) {
		this.capaLugars = capaLugars;
	}

}
