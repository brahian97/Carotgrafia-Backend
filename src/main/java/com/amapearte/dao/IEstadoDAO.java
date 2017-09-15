package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Estado;

public interface IEstadoDAO {
	
	public void save(Estado estado);
	public void update(Estado estado);
	public void delete(Estado estado);
	public Estado findById(Long idestado);
	public List<Estado> findAll();		
}