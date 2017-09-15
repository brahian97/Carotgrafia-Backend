package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Categoria;
import com.amapearte.modelo.CategoriaLugar;
import com.amapearte.modelo.Lugar;

public interface ICategoriaLugarLogica {
	
	public void save(CategoriaLugar categoriaLugar) throws Exception;
	public void update(CategoriaLugar categoriaLugar) throws Exception;
	public void delete(CategoriaLugar categoriaLugar) throws Exception;
	public CategoriaLugar findById(Long idcategorialugar);
	public List<CategoriaLugar> findAll();		
}