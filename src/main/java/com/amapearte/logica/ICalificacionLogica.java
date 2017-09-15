package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Calificacion;

public interface ICalificacionLogica{
	
	public void save(Calificacion calificacion) throws Exception;
	public void update(Calificacion calificacion) throws Exception;
	public void delete(Calificacion calificacion) throws Exception;
	public Calificacion findById(Long idcalificacion);
	public List<Calificacion> findAll();		
}