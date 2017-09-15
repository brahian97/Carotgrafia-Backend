package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.SoporteLugar;

public interface ISoporteLugarLogica {
	
	public void save(SoporteLugar soporteLugar) throws Exception;
	public void update(SoporteLugar soporteLugar) throws Exception;
	public void delete(SoporteLugar soporteLugar) throws Exception;
	public SoporteLugar findById(Long id);
	public List<SoporteLugar> findAll();		
}