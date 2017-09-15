package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.ArteInteresArtista;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;

public interface IArteInteresArtistaLogica{
	
	public void save(ArteInteresArtista arteInteresArtista) throws Exception;
	public void update(ArteInteresArtista arteInteresArtista) throws Exception;
	public void delete(ArteInteresArtista arteInteresArtista) throws Exception;
	public ArteInteresArtista findById(Long id);
	public List<ArteInteresArtista> findAll();		
	
}