package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Rol;

public interface IRolLogica {
	
	public void save(Rol rol) throws Exception;
	public void update(Rol rol) throws Exception;
	public void delete(Rol rol) throws Exception;
	public Rol findById(Long id);
	public List<Rol> findAll();		
}