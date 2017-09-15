package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Categoria;

public interface ICategoriaLogica {
	
	public void save(Categoria categoria) throws Exception;
	public void update(Categoria categoria) throws Exception;
	public void delete(Categoria categoria) throws Exception;
	public Categoria findById(Long idcategoria);
	public List<Categoria> findAll();		
}