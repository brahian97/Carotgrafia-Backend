package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Soporte;

public interface ISoporteDAO {
	
	public void save(Soporte soporte);
	public void update(Soporte soporte);
	public void delete(Soporte soporte);
	public Soporte findById(Long id);
	public List<Soporte> findAll();		
}