package com.amapearte.dao;

import java.util.List;


import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Usuario;

public interface IArtistaDAO{
	
	public void save(Artista artista);
	public void update(Artista artista);
	public void delete(Artista artista);
	public Artista findById(Long idartista);
	public List<Artista> findAll();		
	
}