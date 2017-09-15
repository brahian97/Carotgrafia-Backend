package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.TipoSoporte;

public interface ITipoSoporteDAO {
	
	public void save(TipoSoporte tipoSoporte);
	public void update(TipoSoporte tipoSoporte);
	public void delete(TipoSoporte tipoSoporte);
	public TipoSoporte findById(Long id);
	public List<TipoSoporte> findAll();		
}