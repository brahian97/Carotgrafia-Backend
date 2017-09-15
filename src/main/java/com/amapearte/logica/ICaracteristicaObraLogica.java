package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Caracteristica;
import com.amapearte.modelo.CaracteristicaObra;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.ValorCaracteristicaObra;

public interface ICaracteristicaObraLogica {
	
	public void save(CaracteristicaObra caracteristicaObra) throws Exception;
	public void update(CaracteristicaObra caracteristicaObra) throws Exception;
	public void delete(CaracteristicaObra caracteristicaObra) throws Exception;
	public CaracteristicaObra findById(Long idcaracteristicaobra);
	public List<CaracteristicaObra> findAll();		
}