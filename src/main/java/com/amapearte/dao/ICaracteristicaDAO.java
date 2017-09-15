package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Caracteristica;

public interface ICaracteristicaDAO{
	
	public void save(Caracteristica caracteristica);
	public void update(Caracteristica caracteristica);
	public void delete(Caracteristica caracteristica);
	public Caracteristica findById(Long idcaracteristica);
	public List<Caracteristica> findAll();		
}