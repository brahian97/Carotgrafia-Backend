package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.GrupoExpresionArtistica;

public interface IGrupoExpresionArtisticaLogica {
	
	public void save(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception;
	public void update(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception;
	public void delete(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception;
	public GrupoExpresionArtistica findById(Long id);
	public List<GrupoExpresionArtistica> findAll();		
}