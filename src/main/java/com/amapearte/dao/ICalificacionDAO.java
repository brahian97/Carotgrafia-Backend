package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Calificacion;

public interface ICalificacionDAO{
	
	public void save(Calificacion calificacion);
	public void update(Calificacion calificacion);
	public void delete(Calificacion calificacion);
	public Calificacion findById(Long idcalificacion);
	public List<Calificacion> findAll();		
}