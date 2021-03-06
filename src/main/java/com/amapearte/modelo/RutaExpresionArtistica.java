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
 * RutaExpresionArtistica generated by hbm2java
 */
@Entity
@Table(name = "ruta_expresion_artistica", schema = "public")
public class RutaExpresionArtistica implements java.io.Serializable {
	@NotNull(message="El idrutaexpresionartistica es obligatorio")		
	private int idrutaexpresionartistica;
	@NotNull(message="El idexpresionartistica es obligatorio")		
	private ExpresionArtistica expresionArtistica;
	@NotNull(message="El idruta es obligatorio")		
	private Ruta ruta;

	public RutaExpresionArtistica() {
	}

	public RutaExpresionArtistica(int idrutaexpresionartistica) {
		this.idrutaexpresionartistica = idrutaexpresionartistica;
	}

	public RutaExpresionArtistica(int idrutaexpresionartistica, ExpresionArtistica expresionArtistica, Ruta ruta) {
		this.idrutaexpresionartistica = idrutaexpresionartistica;
		this.expresionArtistica = expresionArtistica;
		this.ruta = ruta;
	}

	@Id

	@Column(name = "idrutaexpresionartistica", unique = true, nullable = false)
	public int getIdrutaexpresionartistica() {
		return this.idrutaexpresionartistica;
	}

	public void setIdrutaexpresionartistica(int idrutaexpresionartistica) {
		this.idrutaexpresionartistica = idrutaexpresionartistica;
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
	@JoinColumn(name = "idruta")
	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}
