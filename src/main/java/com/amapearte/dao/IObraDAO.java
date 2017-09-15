package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Obra;

public interface IObraDAO {
	
	public void save(Obra obra);
	public void update(Obra obra);
	public void delete(Obra obra);
	public Obra findById(Long id);
	public List<Obra> findAll();		
}