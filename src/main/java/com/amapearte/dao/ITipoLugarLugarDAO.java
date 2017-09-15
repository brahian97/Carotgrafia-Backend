package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.TipoLugarLugar;

public interface ITipoLugarLugarDAO {
	
	public void save(TipoLugarLugar tipoLugarLugar);
	public void update(TipoLugarLugar tipoLugarLugar);
	public void delete(TipoLugarLugar tipoLugarLugar);
	public TipoLugarLugar findById(Long id);
	public List<TipoLugarLugar> findAll();		
}