package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.RutaObra;

public interface IRutaObraLogica {
	
	public void save(RutaObra rutaObra) throws Exception;
	public void update(RutaObra rutaObra) throws Exception;
	public void delete(RutaObra rutaObra) throws Exception;
	public RutaObra findById(Long id);
	public List<RutaObra> findAll();		
}