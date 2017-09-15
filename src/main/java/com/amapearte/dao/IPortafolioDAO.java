package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Portafolio;

public interface IPortafolioDAO {
	
	public void save(Portafolio portafolio);
	public void update(Portafolio portafolio);
	public void delete(Portafolio portafolio);
	public Portafolio findById(Long id);
	public List<Portafolio> findAll();		
}