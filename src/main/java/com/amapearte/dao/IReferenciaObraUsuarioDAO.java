package com.amapearte.dao;



import java.util.List;
import com.amapearte.modelo.ReferenciaObraUsuario;

public interface IReferenciaObraUsuarioDAO {
	
	public void save(ReferenciaObraUsuario referenciaObraUsuario);
	public void update(ReferenciaObraUsuario referenciaObraUsuario);
	public void delete(ReferenciaObraUsuario referenciaObraUsuario);
	public ReferenciaObraUsuario findById(Long id);
	public List<ReferenciaObraUsuario> findAll();		
}