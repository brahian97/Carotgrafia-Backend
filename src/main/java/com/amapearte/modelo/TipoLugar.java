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
 * TipoLugar generated by hbm2java
 */
@Entity
@Table(name = "tipo_lugar", schema = "public")
public class TipoLugar implements java.io.Serializable {
	@NotNull(message="El idtipolugar es obligatorio")		
	private int idtipolugar;
	@NotNull(message="El nombretipolugar es obligatorio")	
	@Size(min = 1,max=100,message="Minimo de caracteres es 1 y maximo 100 para nombre tipo lugar")
	private String nombretipolugar;
	@NotNull(message="El desctipolugar es obligatorio")	
	@Size(min = 1,max=100,message="Minimo de caracteres es 1 y maximo 100 para desctipolugar")
	private String desctipolugar;
	@NotNull(message="El icono es obligatorio")	
	@Size(min = 1,max=100,message="Minimo de caracteres es 1 y maximo 255 para icono")
	private String icono;
	private Set<TipoLugarLugar> tipoLugarLugars = new HashSet<TipoLugarLugar>(0);

	public TipoLugar() {
	}

	public TipoLugar(int idtipolugar, String nombretipolugar, String desctipolugar, String icono) {
		this.idtipolugar = idtipolugar;
		this.nombretipolugar = nombretipolugar;
		this.desctipolugar = desctipolugar;
		this.icono = icono;
	}

	public TipoLugar(int idtipolugar, String nombretipolugar, String desctipolugar, String icono,
			Set<TipoLugarLugar> tipoLugarLugars) {
		this.idtipolugar = idtipolugar;
		this.nombretipolugar = nombretipolugar;
		this.desctipolugar = desctipolugar;
		this.icono = icono;
		this.tipoLugarLugars = tipoLugarLugars;
	}

	@Id

	@Column(name = "idtipolugar", unique = true, nullable = false)
	public int getIdtipolugar() {
		return this.idtipolugar;
	}

	public void setIdtipolugar(int idtipolugar) {
		this.idtipolugar = idtipolugar;
	}

	@Column(name = "nombretipolugar", nullable = false, length = 100)
	public String getNombretipolugar() {
		return this.nombretipolugar;
	}

	public void setNombretipolugar(String nombretipolugar) {
		this.nombretipolugar = nombretipolugar;
	}

	@Column(name = "desctipolugar", nullable = false)
	public String getDesctipolugar() {
		return this.desctipolugar;
	}

	public void setDesctipolugar(String desctipolugar) {
		this.desctipolugar = desctipolugar;
	}

	@Column(name = "icono", nullable = false)
	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoLugar")
	public Set<TipoLugarLugar> getTipoLugarLugars() {
		return this.tipoLugarLugars;
	}

	public void setTipoLugarLugars(Set<TipoLugarLugar> tipoLugarLugars) {
		this.tipoLugarLugars = tipoLugarLugars;
	}

}
