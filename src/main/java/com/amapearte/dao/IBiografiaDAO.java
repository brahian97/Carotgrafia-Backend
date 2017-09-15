package com.amapearte.dao;

import java.util.Date;
import java.util.List;

import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;

public interface IBiografiaDAO{
	
	public void save(Biografia biografia);
	public void update(Biografia biografia);
	public void delete(Biografia biografia);
	public Biografia findById(Long idbiografia);
	public List<Biografia> findAll();		
}