package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ArtistaGrupo;
import com.amapearte.modelo.Grupo;

public interface IArtistaGrupoLogica{
	
	public void save(ArtistaGrupo artistaGrupo) throws Exception;
	public void update(ArtistaGrupo artistaGrupo) throws Exception;
	public void delete(ArtistaGrupo artistaGrupo) throws Exception;
	public ArtistaGrupo findById(Long idartistagrupo);
	public List<ArtistaGrupo> findAll();		
}