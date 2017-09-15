package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ArtistaGrupo;
import com.amapearte.modelo.Grupo;

public interface IArtistaGrupoDAO{
	
	public void save(ArtistaGrupo artistaGrupo);
	public void update(ArtistaGrupo artistaGrupo);
	public void delete(ArtistaGrupo artistaGrupo);
	public ArtistaGrupo findById(Long idartistagrupo);
	public List<ArtistaGrupo> findAll();		
}