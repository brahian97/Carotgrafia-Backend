package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Capa;
import com.amapearte.modelo.CapaLugar;
import com.amapearte.modelo.Lugar;

public interface ICapaLugarLogica{
	
	public void save(CapaLugar capaLugar) throws Exception;
	public void update(CapaLugar capaLugar) throws Exception;
	public void delete(CapaLugar capaLugar) throws Exception;
	public CapaLugar findById( Long idcapalugar);
	public List<CapaLugar> findAll();		
}