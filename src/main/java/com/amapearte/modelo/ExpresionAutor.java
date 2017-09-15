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
 * ExpresionAutor generated by hbm2java
 */
@Entity
@Table(name = "expresion_autor", schema = "public")
public class ExpresionAutor implements java.io.Serializable {
	@NotNull(message = "El idexpresionautor es obligatorio")
	private int idexpresionautor;
	@NotNull(message = "El idartista es obligatorio")
	private Artista artista;
	@NotNull(message = "El idexpresionartistica es obligatorio")
	private ExpresionArtistica expresionArtistica;

	public ExpresionAutor() {
	}

	public ExpresionAutor(int idexpresionautor) {
		this.idexpresionautor = idexpresionautor;
	}

	public ExpresionAutor(int idexpresionautor, Artista artista, ExpresionArtistica expresionArtistica) {
		this.idexpresionautor = idexpresionautor;
		this.artista = artista;
		this.expresionArtistica = expresionArtistica;
	}

	@Id

	@Column(name = "idexpresionautor", unique = true, nullable = false)
	public int getIdexpresionautor() {
		return this.idexpresionautor;
	}

	public void setIdexpresionautor(int idexpresionautor) {
		this.idexpresionautor = idexpresionautor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idartista")
	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idexpresionartistica")
	public ExpresionArtistica getExpresionArtistica() {
		return this.expresionArtistica;
	}

	public void setExpresionArtistica(ExpresionArtistica expresionArtistica) {
		this.expresionArtistica = expresionArtistica;
	}

}