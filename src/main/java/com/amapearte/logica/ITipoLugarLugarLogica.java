package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.TipoLugarLugar;

public interface ITipoLugarLugarLogica {
	
	public void save(TipoLugarLugar tipoLugarLugar) throws Exception;
	public void update(TipoLugarLugar tipoLugarLugar) throws Exception;
	public void delete(TipoLugarLugar tipoLugarLugar) throws Exception;
	public TipoLugarLugar findById(Long id);
	public List<TipoLugarLugar> findAll();		
}