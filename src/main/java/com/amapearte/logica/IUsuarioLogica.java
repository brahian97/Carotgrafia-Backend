package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Usuario;

public interface IUsuarioLogica {
	
	public void save(Usuario usuario) throws Exception;
	public void update(Usuario usuario) throws Exception;
	public void delete(Usuario usuario) throws Exception;
	public Usuario findById(Long id);
	public List<Usuario> findAll();		
}