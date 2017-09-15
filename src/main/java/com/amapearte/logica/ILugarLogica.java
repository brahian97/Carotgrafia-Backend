package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Lugar;

public interface ILugarLogica {
	
	public void save(Lugar lugar) throws Exception;
	public void update(Lugar lugar) throws Exception;
	public void delete(Lugar lugar) throws Exception;
	public Lugar findById(Long id);
	public List<Lugar> findAll();		
}