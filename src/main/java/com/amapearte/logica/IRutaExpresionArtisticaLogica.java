package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.RutaExpresionArtistica;

public interface IRutaExpresionArtisticaLogica {
	
	public void save(RutaExpresionArtistica rutaExpresionArtistica) throws Exception;
	public void update(RutaExpresionArtistica rutaExpresionArtistica) throws Exception;
	public void delete(RutaExpresionArtistica rutaExpresionArtistica) throws Exception;
	public RutaExpresionArtistica findById(Long id);
	public List<RutaExpresionArtistica> findAll();		
}