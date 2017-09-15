package com.amapearte.modelo;
// Generated 5/08/2017 04:28:14 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Ruta generated by hbm2java
 */
@Entity
@Table(name = "ruta", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "nombreruta"))
public class Ruta implements java.io.Serializable {
	@NotNull(message="El idruta es obligatorio")		
	private int idruta;
	@NotNull(message="El idestado es obligatorio")		
	private Estado estado;
	@NotNull(message="El idusuario es obligatorio")		
	private Usuario usuario;
	@NotNull(message="El nombreruta es obligatorio")	
	@Size(min = 1,max=200,message="Minimo de caracteres es 1 y maximo 200 para nombreruta")
	private String nombreruta;
	@NotNull(message="La imagenruta es obligatorio")	
	@Size(min = 1,max=255,message="Minimo de caracteres es 1 y maximo 255 imagenruta")
	private String imagenruta;
	@NotNull(message="El descruta es obligatorio")	
	@Size(min = 1,message="Minimo de caracteres es 1 para descruta")
	private String descruta;
	@NotNull(message="La fecha creaci�n es obligatorio")		
	private Date fechacreacion;
	@NotNull(message="La fecha aprobaci�n es obligatorio")		
	private Date fechaaprobacion;

	private int visitas;
	
	private int votosmegusta;
	
	private int votosnomegusta;
	private Set<Comentario> comentarios = new HashSet<Comentario>(0);
	private Set<RutaExpresionArtistica> rutaExpresionArtisticas = new HashSet<RutaExpresionArtistica>(0);
	private Set<RutaObra> rutaObras = new HashSet<RutaObra>(0);

	public Ruta() {
	}

	public Ruta(int idruta, String nombreruta, String imagenruta, String descruta, Date fechacreacion, int visitas,
			int votosmegusta, int votosnomegusta) {
		this.idruta = idruta;
		this.nombreruta = nombreruta;
		this.imagenruta = imagenruta;
		this.descruta = descruta;
		this.fechacreacion = fechacreacion;
		this.visitas = visitas;
		this.votosmegusta = votosmegusta;
		this.votosnomegusta = votosnomegusta;
	}

	public Ruta(int idruta, Estado estado, Usuario usuario, String nombreruta, String imagenruta, String descruta,
			Date fechacreacion, Date fechaaprobacion, int visitas, int votosmegusta, int votosnomegusta,
			Set<Comentario> comentarios, Set<RutaExpresionArtistica> rutaExpresionArtisticas, Set<RutaObra> rutaObras) {
		this.idruta = idruta;
		this.estado = estado;
		this.usuario = usuario;
		this.nombreruta = nombreruta;
		this.imagenruta = imagenruta;
		this.descruta = descruta;
		this.fechacreacion = fechacreacion;
		this.fechaaprobacion = fechaaprobacion;
		this.visitas = visitas;
		this.votosmegusta = votosmegusta;
		this.votosnomegusta = votosnomegusta;
		this.comentarios = comentarios;
		this.rutaExpresionArtisticas = rutaExpresionArtisticas;
		this.rutaObras = rutaObras;
	}

	@Id

	@Column(name = "idruta", unique = true, nullable = false)
	public int getIdruta() {
		return this.idruta;
	}

	public void setIdruta(int idruta) {
		this.idruta = idruta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idestado")
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nombreruta", unique = true, nullable = false, length = 200)
	public String getNombreruta() {
		return this.nombreruta;
	}

	public void setNombreruta(String nombreruta) {
		this.nombreruta = nombreruta;
	}

	@Column(name = "imagenruta", nullable = false)
	public String getImagenruta() {
		return this.imagenruta;
	}

	public void setImagenruta(String imagenruta) {
		this.imagenruta = imagenruta;
	}

	@Column(name = "descruta", nullable = false)
	public String getDescruta() {
		return this.descruta;
	}

	public void setDescruta(String descruta) {
		this.descruta = descruta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechacreacion", nullable = false, length = 22)
	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaaprobacion", length = 22)
	public Date getFechaaprobacion() {
		return this.fechaaprobacion;
	}

	public void setFechaaprobacion(Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	@Column(name = "visitas", nullable = false)
	public int getVisitas() {
		return this.visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	@Column(name = "votosmegusta", nullable = false)
	public int getVotosmegusta() {
		return this.votosmegusta;
	}

	public void setVotosmegusta(int votosmegusta) {
		this.votosmegusta = votosmegusta;
	}

	@Column(name = "votosnomegusta", nullable = false)
	public int getVotosnomegusta() {
		return this.votosnomegusta;
	}

	public void setVotosnomegusta(int votosnomegusta) {
		this.votosnomegusta = votosnomegusta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ruta")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ruta")
	public Set<RutaExpresionArtistica> getRutaExpresionArtisticas() {
		return this.rutaExpresionArtisticas;
	}

	public void setRutaExpresionArtisticas(Set<RutaExpresionArtistica> rutaExpresionArtisticas) {
		this.rutaExpresionArtisticas = rutaExpresionArtisticas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ruta")
	public Set<RutaObra> getRutaObras() {
		return this.rutaObras;
	}

	public void setRutaObras(Set<RutaObra> rutaObras) {
		this.rutaObras = rutaObras;
	}

}