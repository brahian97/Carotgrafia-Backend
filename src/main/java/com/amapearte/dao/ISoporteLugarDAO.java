package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.SoporteLugar;

public interface ISoporteLugarDAO {
	
	public void save(SoporteLugar soporteLugar);
	public void update(SoporteLugar soporteLugar);
	public void delete(SoporteLugar soporteLugar);
	public SoporteLugar findById(Long id);
	public List<SoporteLugar> findAll();		
}