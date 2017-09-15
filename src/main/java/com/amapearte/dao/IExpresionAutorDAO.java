package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;
import com.amapearte.modelo.ExpresionAutor;

public interface IExpresionAutorDAO {
	
	public void save(ExpresionAutor expresionAutor);
	public void update(ExpresionAutor expresionAutor);
	public void delete(ExpresionAutor expresionAutor);
	public ExpresionAutor findById(Long idexpresionautor);
	public List<ExpresionAutor> findAll();		
}