package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.RutaObra;

public interface IRutaObraDAO {
	
	public void save(RutaObra rutaObra);
	public void update(RutaObra rutaObra);
	public void delete(RutaObra rutaObra);
	public RutaObra findById(Long id);
	public List<RutaObra> findAll();		
}