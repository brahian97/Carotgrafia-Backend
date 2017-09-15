package com.amapearte.logica;

import java.util.Date;
import java.util.List;

import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;

public interface IBiografiaLogica{
	
	public void save(Biografia biografia) throws Exception;
	public void update(Biografia biografia) throws Exception;
	public void delete(Biografia biografia) throws Exception;
	public Biografia findById(Long idbiografia);
	public List<Biografia> findAll();		
}