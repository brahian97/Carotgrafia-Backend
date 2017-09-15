package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.OpinionUsuario;

public interface IOpinionUsuarioLogica {
	
	public void save(OpinionUsuario opinionUsuario) throws Exception;
	public void update(OpinionUsuario opinionUsuario) throws Exception;
	public void delete(OpinionUsuario opinionUsuario) throws Exception;
	public OpinionUsuario findById(Long id);
	public List<OpinionUsuario> findAll();		
}