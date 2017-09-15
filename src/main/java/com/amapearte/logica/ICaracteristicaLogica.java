package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Caracteristica;

public interface ICaracteristicaLogica{
	
	public void save(Caracteristica caracteristica) throws Exception;
	public void update(Caracteristica caracteristica) throws Exception;
	public void delete(Caracteristica caracteristica) throws Exception;
	public Caracteristica findById(Long idcaracteristica);
	public List<Caracteristica> findAll();		
}