package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.TipoSoporte;

public interface ITipoSoporteLogica {
	
	public void save(TipoSoporte tipoSoporte) throws Exception;
	public void update(TipoSoporte tipoSoporte) throws Exception;
	public void delete(TipoSoporte tipoSoporte) throws Exception;
	public TipoSoporte findById(Long id);
	public List<TipoSoporte> findAll();		
}