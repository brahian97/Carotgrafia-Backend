package com.amapearte.logica;

import java.util.List;
import com.amapearte.modelo.ReferenciaObraUsuario;

public interface IReferenciaObraUsuarioLogica {
	
	public void save(ReferenciaObraUsuario referenciaObraUsuario) throws Exception;
	public void update(ReferenciaObraUsuario referenciaObraUsuario) throws Exception;
	public void delete(ReferenciaObraUsuario referenciaObraUsuario) throws Exception;
	public ReferenciaObraUsuario findById(Long id);
	public List<ReferenciaObraUsuario> findAll();		
}