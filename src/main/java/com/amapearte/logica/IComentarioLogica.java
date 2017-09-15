package com.amapearte.logica;

import java.util.List;

import com.amapearte.modelo.Comentario;
import com.amapearte.modelo.Ruta;
import com.amapearte.modelo.Usuario;

public interface IComentarioLogica {
	
	public void save(Comentario comentario) throws Exception;
	public void update(Comentario comentario) throws Exception;
	public void delete(Comentario comentario) throws Exception;
	public Comentario findById(Long idcomentario);
	public List<Comentario> findAll();		
}