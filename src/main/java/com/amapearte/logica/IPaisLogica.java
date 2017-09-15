package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Pais;

public interface IPaisLogica {
	
	public void save(Pais pais) throws Exception;
	public void update(Pais pais) throws Exception;
	public void delete(Pais pais) throws Exception;
	public Pais findById(Long id);
	public List<Pais> findAll();		
}