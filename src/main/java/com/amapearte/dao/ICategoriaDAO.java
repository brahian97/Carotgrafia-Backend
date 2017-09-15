package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Categoria;

public interface ICategoriaDAO {
	
	public void save(Categoria categoria);
	public void update(Categoria categoria);
	public void delete(Categoria categoria);
	public Categoria findById(Long idcategoria);
	public List<Categoria> findAll();		
}