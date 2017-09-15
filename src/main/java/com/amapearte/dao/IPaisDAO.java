package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Pais;

public interface IPaisDAO {
	
	public void save(Pais pais);
	public void update(Pais pais);
	public void delete(Pais pais);
	public Pais findById(Long id);
	public List<Pais> findAll();		
}