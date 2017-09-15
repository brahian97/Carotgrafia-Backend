package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.TipoLugar;

public interface ITipoLugarDAO {
	
	public void save(TipoLugar tipoLugar);
	public void update(TipoLugar tipoLugar);
	public void delete(TipoLugar tipoLugar);
	public TipoLugar findById(Long id);
	public List<TipoLugar> findAll();		
}