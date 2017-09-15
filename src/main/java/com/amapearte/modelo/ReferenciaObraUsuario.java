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
 * ReferenciaObraUsuario generated by hbm2java
 */
@Entity
@Table(name = "referencia_obra_usuario", schema = "public")
public class ReferenciaObraUsuario implements java.io.Serializable {
	@NotNull(message="El idreferenciaobrausuario es obligatorio")		
	private int idreferenciaobrausuario;
	@NotNull(message="El idobra es obligatorio")		
	private Obra obra;
	@NotNull(message="El idusuario es obligatorio")		
	private Usuario usuario;
	@NotNull(message="La observaci�n es obligatorio")	
	@Size(min = 5,message="Minimo de caracteres es 5 para la observacion")
	private String observacion;

	public ReferenciaObraUsuario() {
	}

	public ReferenciaObraUsuario(int idreferenciaobrausuario) {
		this.idreferenciaobrausuario = idreferenciaobrausuario;
	}

	public ReferenciaObraUsuario(int idreferenciaobrausuario, Obra obra, Usuario usuario, String observacion) {
		this.idreferenciaobrausuario = idreferenciaobrausuario;
		this.obra = obra;
		this.usuario = usuario;
		this.observacion = observacion;
	}

	@Id

	@Column(name = "idreferenciaobrausuario", unique = true, nullable = false)
	public int getIdreferenciaobrausuario() {
		return this.idreferenciaobrausuario;
	}

	public void setIdreferenciaobrausuario(int idreferenciaobrausuario) {
		this.idreferenciaobrausuario = idreferenciaobrausuario;
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

	@Column(name = "observacion")
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
