package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Grupo;

public interface IGrupoLogica {
	
	public void save(Grupo grupo) throws Exception;
	public void update(Grupo grupo) throws Exception;
	public void delete(Grupo grupo) throws Exception;
	public Grupo findById(Long idgrupo);
	public List<Grupo> findAll();		
}