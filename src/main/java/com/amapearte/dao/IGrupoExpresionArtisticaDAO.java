package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.GrupoExpresionArtistica;

public interface IGrupoExpresionArtisticaDAO {
	
	public void save(GrupoExpresionArtistica grupoExpresionArtistica);
	public void update(GrupoExpresionArtistica grupoExpresionArtistica);
	public void delete(GrupoExpresionArtistica grupoExpresionArtistica);
	public GrupoExpresionArtistica findById(Long id);
	public List<GrupoExpresionArtistica> findAll();		
}