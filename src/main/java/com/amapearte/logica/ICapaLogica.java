package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Capa;

public interface ICapaLogica{
	
	public void save(Capa capa) throws Exception;
	public void update(Capa capa) throws Exception;
	public void delete(Capa capa) throws Exception;
	public Capa findById(Long idcapa);
	public List<Capa> findAll();		
}