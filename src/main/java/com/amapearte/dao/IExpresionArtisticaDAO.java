package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.ExpresionArtistica;

public interface IExpresionArtisticaDAO {
	
	public void save(ExpresionArtistica expresionArtistica);
	public void update(ExpresionArtistica expresionArtistica);
	public void delete(ExpresionArtistica expresionArtistica);
	public ExpresionArtistica findById(Long idexpresionartistica);
	public List<ExpresionArtistica> findAll();		
}