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
 * GrupoExpresionArtistica generated by hbm2java
 */
@Entity
@Table(name = "grupo_expresion_artistica", schema = "public")
public class GrupoExpresionArtistica implements java.io.Serializable {
	@NotNull(message = "El idgrupoexpresionartistica es obligatorio")
	private int idgrupoexpresionartistica;
	@NotNull(message = "El idexpresionartistica es obligatorio")
	private ExpresionArtistica expresionArtistica;
	@NotNull(message = "El idgrupo es obligatorio")
	private Grupo grupo;

	public GrupoExpresionArtistica() {
	}

	public GrupoExpresionArtistica(int idgrupoexpresionartistica) {
		this.idgrupoexpresionartistica = idgrupoexpresionartistica;
	}

	public GrupoExpresionArtistica(int idgrupoexpresionartistica, ExpresionArtistica expresionArtistica, Grupo grupo) {
		this.idgrupoexpresionartistica = idgrupoexpresionartistica;
		this.expresionArtistica = expresionArtistica;
		this.grupo = grupo;
	}

	@Id

	@Column(name = "idgrupoexpresionartistica", unique = true, nullable = false)
	public int getIdgrupoexpresionartistica() {
		return this.idgrupoexpresionartistica;
	}

	public void setIdgrupoexpresionartistica(int idgrupoexpresionartistica) {
		this.idgrupoexpresionartistica = idgrupoexpresionartistica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idexpresionartistica")
	public ExpresionArtistica getExpresionArtistica() {
		return this.expresionArtistica;
	}

	public void setExpresionArtistica(ExpresionArtistica expresionArtistica) {
		this.expresionArtistica = expresionArtistica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgrupo")
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}