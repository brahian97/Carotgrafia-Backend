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
 * Soporte generated by hbm2java
 */
@Entity
@Table(name = "soporte", schema = "public")
public class Soporte implements java.io.Serializable {
	@NotNull(message="El idsoporte es obligatorio")		
	private int idsoporte;
	@NotNull(message="El idobra es obligatorio")		
	private Obra obra;
	@NotNull(message="El idtiposoporte es obligatorio")	
	private TipoSoporte tipoSoporte;
	@NotNull(message="La descripcion es obligatorio")	
	@Size(min = 1,max=60,message="Minimo de caracteres es 1 y maximo 60 de la descripcion")
	private String descripcion;

	public Soporte() {
	}

	public Soporte(int idsoporte, String descripcion) {
		this.idsoporte = idsoporte;
		this.descripcion = descripcion;
	}

	public Soporte(int idsoporte, Obra obra, TipoSoporte tipoSoporte, String descripcion) {
		this.idsoporte = idsoporte;
		this.obra = obra;
		this.tipoSoporte = tipoSoporte;
		this.descripcion = descripcion;
	}

	@Id

	@Column(name = "idsoporte", unique = true, nullable = false)
	public int getIdsoporte() {
		return this.idsoporte;
	}

	public void setIdsoporte(int idsoporte) {
		this.idsoporte = idsoporte;
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
	@JoinColumn(name = "idtiposoporte")
	public TipoSoporte getTipoSoporte() {
		return this.tipoSoporte;
	}

	public void setTipoSoporte(TipoSoporte tipoSoporte) {
		this.tipoSoporte = tipoSoporte;
	}

	@Column(name = "descripcion", nullable = false, length = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
