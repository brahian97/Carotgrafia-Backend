package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Ruta;

public interface IRutaDAO {
	
	public void save(Ruta ruta);
	public void update(Ruta ruta);
	public void delete(Ruta ruta);
	public Ruta findById(Long id);
	public List<Ruta> findAll();		
}