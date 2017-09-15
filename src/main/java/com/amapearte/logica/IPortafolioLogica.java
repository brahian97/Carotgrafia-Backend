package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Portafolio;

public interface IPortafolioLogica {
	
	public void save(Portafolio portafolio) throws Exception;
	public void update(Portafolio portafolio) throws Exception;
	public void delete(Portafolio portafolio) throws Exception;
	public Portafolio findById(Long id);
	public List<Portafolio> findAll();		
}