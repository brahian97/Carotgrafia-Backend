package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Caracteristica;
import com.amapearte.modelo.CaracteristicaObra;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.ValorCaracteristicaObra;

public interface ICaracteristicaObraDAO {
	
	public void save(CaracteristicaObra caracteristicaObra);
	public void update(CaracteristicaObra caracteristicaObra);
	public void delete(CaracteristicaObra caracteristicaObra);
	public CaracteristicaObra findById(Long idcaracteristicaobra);
	public List<CaracteristicaObra> findAll();		
}