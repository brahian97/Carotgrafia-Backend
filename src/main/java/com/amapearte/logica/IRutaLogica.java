package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Ruta;

public interface IRutaLogica {
	
	public void save(Ruta ruta) throws Exception;
	public void update(Ruta ruta) throws Exception;
	public void delete(Ruta ruta) throws Exception;
	public Ruta findById(Long id);
	public List<Ruta> findAll();		
}