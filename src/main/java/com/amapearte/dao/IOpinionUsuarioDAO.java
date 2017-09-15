package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.OpinionUsuario;

public interface IOpinionUsuarioDAO {
	
	public void save(OpinionUsuario opinionUsuario);
	public void update(OpinionUsuario opinionUsuario);
	public void delete(OpinionUsuario opinionUsuario);
	public OpinionUsuario findById(Long id);
	public List<OpinionUsuario> findAll();		
}