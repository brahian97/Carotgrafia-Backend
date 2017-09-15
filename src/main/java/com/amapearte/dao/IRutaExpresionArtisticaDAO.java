package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.RutaExpresionArtistica;

public interface IRutaExpresionArtisticaDAO {
	
	public void save(RutaExpresionArtistica rutaExpresionArtistica);
	public void update(RutaExpresionArtistica rutaExpresionArtistica);
	public void delete(RutaExpresionArtistica rutaExpresionArtistica);
	public RutaExpresionArtistica findById(Long id);
	public List<RutaExpresionArtistica> findAll();		
}