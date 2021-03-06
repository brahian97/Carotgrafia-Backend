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
import javax.validation.constraints.Size;

/**
 * OpinionUsuario generated by hbm2java
 */
@Entity
@Table(name = "opinion_usuario", schema = "public")
public class OpinionUsuario implements java.io.Serializable {
	@NotNull(message="El idopinionusuario es obligatorio")	
	private int idopinionusuario;
	@NotNull(message="El idcalificacion es obligatorio")	
	private Calificacion calificacion;
	@NotNull(message="El idobra es obligatorio")		
	private Obra obra;
	@NotNull(message="El idusuario es obligatorio")		
	private Usuario usuario;
	@NotNull(message="El comentario es obligatorio")		
	@Size(min = 5,message="Minimo de caracteres es 5 para comentario")
	private String comentario;

	public OpinionUsuario() {
	}

	public OpinionUsuario(int idopinionusuario, String comentario) {
		this.idopinionusuario = idopinionusuario;
		this.comentario = comentario;
	}

	public OpinionUsuario(int idopinionusuario, Calificacion calificacion, Obra obra, Usuario usuario,
			String comentario) {
		this.idopinionusuario = idopinionusuario;
		this.calificacion = calificacion;
		this.obra = obra;
		this.usuario = usuario;
		this.comentario = comentario;
	}

	@Id

	@Column(name = "idopinionusuario", unique = true, nullable = false)
	public int getIdopinionusuario() {
		return this.idopinionusuario;
	}

	public void setIdopinionusuario(int idopinionusuario) {
		this.idopinionusuario = idopinionusuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcalificacion")
	public Calificacion getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idobra")
	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "comentario", nullable = false)
	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
