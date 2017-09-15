package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Rol;

public interface IRolDAO {
	
	public void save(Rol rol);
	public void update(Rol rol);
	public void delete(Rol rol);
	public Rol findById(Long id);
	public List<Rol> findAll();		
}