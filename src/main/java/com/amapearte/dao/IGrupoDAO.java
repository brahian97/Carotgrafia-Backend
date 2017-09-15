package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Grupo;

public interface IGrupoDAO {
	
	public void save(Grupo grupo);
	public void update(Grupo grupo);
	public void delete(Grupo grupo);
	public Grupo findById(Long idgrupo);
	public List<Grupo> findAll();		
}