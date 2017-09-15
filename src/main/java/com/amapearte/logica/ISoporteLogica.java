package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Soporte;

public interface ISoporteLogica {
	
	public void save(Soporte soporte) throws Exception;
	public void update(Soporte soporte) throws Exception;
	public void delete(Soporte soporte) throws Exception;
	public Soporte findById(Long id);
	public List<Soporte> findAll();		
}