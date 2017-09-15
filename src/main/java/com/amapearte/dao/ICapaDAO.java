package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Capa;

public interface ICapaDAO{
	
	public void save(Capa capa);
	public void update(Capa capa);
	public void delete(Capa capa);
	public Capa findById(Long idcapa);
	public List<Capa> findAll();		
}