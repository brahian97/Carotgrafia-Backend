package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Lugar;

public interface ILugarDAO {
	
	public void save(Lugar lugar);
	public void update(Lugar lugar);
	public void delete(Lugar lugar);
	public Lugar findById(Long id);
	public List<Lugar> findAll();		
}