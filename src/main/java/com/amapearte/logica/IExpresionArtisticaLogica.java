package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.ExpresionArtistica;

public interface IExpresionArtisticaLogica {
	
	public void save(ExpresionArtistica expresionArtistica) throws Exception;
	public void update(ExpresionArtistica expresionArtistica) throws Exception;
	public void delete(ExpresionArtistica expresionArtistica) throws Exception;
	public ExpresionArtistica findById(Long idexpresionartistica);
	public List<ExpresionArtistica> findAll();		
}