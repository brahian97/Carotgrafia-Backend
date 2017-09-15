package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.ExpresionArtisticaCaracteristica;

public interface IExpresionArtisticaCaracteristicaDAO {
	
	public void save(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica);
	public void update(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica);
	public void delete(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica);
	public ExpresionArtisticaCaracteristica findById(Long idexpresionartistica);
	public List<ExpresionArtisticaCaracteristica> findAll();		
}