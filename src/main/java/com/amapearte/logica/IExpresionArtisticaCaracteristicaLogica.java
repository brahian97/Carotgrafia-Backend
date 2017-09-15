package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.ExpresionArtisticaCaracteristica;

public interface IExpresionArtisticaCaracteristicaLogica {
	
	public void save(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception;
	public void update(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception;
	public void delete(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception;
	public ExpresionArtisticaCaracteristica findById(Long idexpresionartistica);
	public List<ExpresionArtisticaCaracteristica> findAll();		
}