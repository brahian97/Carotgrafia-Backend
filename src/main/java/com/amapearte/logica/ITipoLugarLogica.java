package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.TipoLugar;

public interface ITipoLugarLogica {
	
	public void save(TipoLugar tipoLugar) throws Exception;
	public void update(TipoLugar tipoLugar) throws Exception;
	public void delete(TipoLugar tipoLugar) throws Exception;
	public TipoLugar findById(Long id);
	public List<TipoLugar> findAll();		
}