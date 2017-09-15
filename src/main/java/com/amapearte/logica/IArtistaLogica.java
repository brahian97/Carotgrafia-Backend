package com.amapearte.logica;

import java.util.List;


import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Usuario;

public interface IArtistaLogica{
	
	public void save(Artista artista) throws Exception;
	public void update(Artista artista) throws Exception;
	public void delete(Artista artista) throws Exception;
	public Artista findById(Long idartista);
	public List<Artista> findAll();		
	
}