package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.ArteInteresArtista;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;

public interface IArteInteresArtistaDAO{
	
	public void save(ArteInteresArtista arteInteresArtista);
	public void update(ArteInteresArtista arteInteresArtista);
	public void delete(ArteInteresArtista arteInteresArtista);
	public ArteInteresArtista findById(Long id);
	public List<ArteInteresArtista> findAll();		
	
}