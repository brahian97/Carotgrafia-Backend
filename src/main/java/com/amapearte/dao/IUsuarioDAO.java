package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Usuario;

public interface IUsuarioDAO {
	
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Usuario findById(Long id);
	public List<Usuario> findAll();		
}