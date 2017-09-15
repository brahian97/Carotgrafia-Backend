package com.amapearte.dao;

import java.util.List;

import com.amapearte.modelo.Comentario;
import com.amapearte.modelo.Ruta;
import com.amapearte.modelo.Usuario;

public interface IComentarioDAO {
	
	public void save(Comentario comentario);
	public void update(Comentario comentario);
	public void delete(Comentario comentario);
	public Comentario findById(Long idcomentario);
	public List<Comentario> findAll();		
}