package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Categoria;
import com.amapearte.modelo.CategoriaLugar;
import com.amapearte.modelo.Lugar;

public interface ICategoriaLugarDAO {
	
	public void save(CategoriaLugar categoriaLugar);
	public void update(CategoriaLugar categoriaLugar);
	public void delete(CategoriaLugar categoriaLugar);
	public CategoriaLugar findById(Long idcategorialugar);
	public List<CategoriaLugar> findAll();		
}