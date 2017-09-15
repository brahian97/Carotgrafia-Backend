package com.amapearte.logica;

import java.util.List;


import com.amapearte.modelo.ExpresionAutor;

public interface IExpresionAutorLogica {
	
	public void save(ExpresionAutor expresionAutor) throws Exception;
	public void update(ExpresionAutor expresionAutor) throws Exception;
	public void delete(ExpresionAutor expresionAutor) throws Exception;
	public ExpresionAutor findById(Long idexpresionautor) throws Exception;
	public List<ExpresionAutor> findAll();		
}