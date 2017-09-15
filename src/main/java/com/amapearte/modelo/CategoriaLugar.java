package com.amapearte.modelo;
// Generated 5/08/2017 04:28:14 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * CategoriaLugar generated by hbm2java
 */
@Entity
@Table(name = "categoria_lugar", schema = "public")
public class CategoriaLugar implements java.io.Serializable {
	@NotNull(message="El idcategorialugar es obligatorio")	
	private int idcategorialugar;
	@NotNull(message="El idcategoria es obligatorio")	
	private Categoria categoria;
	@NotNull(message="El idlugar es obligatorio")	
	private Lugar lugar;

	public CategoriaLugar() {
	}

	public CategoriaLugar(int idcategorialugar) {
		this.idcategorialugar = idcategorialugar;
	}

	public CategoriaLugar(int idcategorialugar, Categoria categoria, Lugar lugar) {
		this.idcategorialugar = idcategorialugar;
		this.categoria = categoria;
		this.lugar = lugar;
	}

	@Id

	@Column(name = "idcategorialugar", unique = true, nullable = false)
	public int getIdcategorialugar() {
		return this.idcategorialugar;
	}

	public void setIdcategorialugar(int idcategorialugar) {
		this.idcategorialugar = idcategorialugar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idlugar")
	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}