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
 * Calificacion generated by hbm2java
 */
@Entity
@Table(name = "calificacion", schema = "public")
public class Calificacion implements java.io.Serializable {
	@NotNull(message="El idcalificacion es obligatorio")	
	private int idcalificacion;
	@NotNull(message="La descripcion  es obligatorio")
	@Size(min = 1,max=50 ,message="Obligatorio llenar interes amapearte")
	private String descripcion;
	private Set<OpinionUsuario> opinionUsuarios = new HashSet<OpinionUsuario>(0);

	public Calificacion() {
	}

	public Calificacion(int idcalificacion, String descripcion) {
		this.idcalificacion = idcalificacion;
		this.descripcion = descripcion;
	}

	public Calificacion(int idcalificacion, String descripcion, Set<OpinionUsuario> opinionUsuarios) {
		this.idcalificacion = idcalificacion;
		this.descripcion = descripcion;
		this.opinionUsuarios = opinionUsuarios;
	}

	@Id

	@Column(name = "idcalificacion", unique = true, nullable = false)
	public int getIdcalificacion() {
		return this.idcalificacion;
	}

	public void setIdcalificacion(int idcalificacion) {
		this.idcalificacion = idcalificacion;
	}

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calificacion")
	public Set<OpinionUsuario> getOpinionUsuarios() {
		return this.opinionUsuarios;
	}

	public void setOpinionUsuarios(Set<OpinionUsuario> opinionUsuarios) {
		this.opinionUsuarios = opinionUsuarios;
	}

}
