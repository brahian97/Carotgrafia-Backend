package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Estado;

public interface IEstadoLogica {
	
	public void save(Estado estado) throws Exception;
	public void update(Estado estado) throws Exception;
	public void delete(Estado estado) throws Exception;
	public Estado findById(Long idestado);
	public List<Estado> findAll();		
}