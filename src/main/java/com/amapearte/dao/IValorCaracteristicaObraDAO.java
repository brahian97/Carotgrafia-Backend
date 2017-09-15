package com.amapearte.dao;

import com.amapearte.modelo.ValorCaracteristicaObra;

import java.util.List;

public interface IValorCaracteristicaObraDAO {
	
	public void save(ValorCaracteristicaObra valorCaracteristicaObra);
	public void update(ValorCaracteristicaObra valorCaracteristicaObra);
	public void delete(ValorCaracteristicaObra valorCaracteristicaObra);
	public ValorCaracteristicaObra findById(Long id);
	public List<ValorCaracteristicaObra> findAll();		
}