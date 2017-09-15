package com.amapearte.logica;

import com.amapearte.modelo.ValorCaracteristicaObra;

import java.util.List;

public interface IValorCaracteristicaObraLogica {
	
	public void save(ValorCaracteristicaObra valorCaracteristicaObra) throws Exception;
	public void update(ValorCaracteristicaObra valorCaracteristicaObra) throws Exception;
	public void delete(ValorCaracteristicaObra valorCaracteristicaObra) throws Exception;
	public ValorCaracteristicaObra findById(Long id);
	public List<ValorCaracteristicaObra> findAll();		
}