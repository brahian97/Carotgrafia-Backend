package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Obra;

public interface IObraLogica {
	
	public void save(Obra obra) throws Exception;
	public void update(Obra obra) throws Exception;
	public void delete(Obra obra) throws Exception;
	public Obra findById(Long id);
	public List<Obra> findAll();		
}