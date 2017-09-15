package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Capa;
import com.amapearte.modelo.CapaLugar;
import com.amapearte.modelo.Lugar;

public interface ICapaLugarDAO{
	
	public void save(CapaLugar capaLugar);
	public void update(CapaLugar capaLugar);
	public void delete(CapaLugar capaLugar);
	public CapaLugar findById( Long idcapalugar);
	public List<CapaLugar> findAll();		
}