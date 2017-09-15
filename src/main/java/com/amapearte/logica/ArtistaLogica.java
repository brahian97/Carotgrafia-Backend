package com.amapearte.logica;
import java.util.List;
import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amapearte.dao.IArtistaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class ArtistaLogica implements IArtistaLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private Validator validator;

	public void validarArtista(Artista artista) throws Exception {
	    try {
	        Set<ConstraintViolation<Artista>> constraintViolations = validator.validate(artista);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Artista> constraintViolation : constraintViolations) {
	                strMessage.append(constraintViolation.getPropertyPath().toString());
	                strMessage.append(" - ");
	                strMessage.append(constraintViolation.getMessage());
	                strMessage.append(". \n");
	            }

	            throw new Exception(strMessage.toString());
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Artista artista) throws Exception {
		if(artista==null){
			throw new Exception("El artista no puede ser nulo");
		}
		
		validarArtista(artista);
		
		Artista entity=artistaDAO.findById((long)artista.getIdartista());
		if(entity!=null){
			throw new Exception("El Artista con id: "+entity.getIdartista()+" Ya existe");
		}
		
		Usuario usuario=usuarioDAO.findById((long)artista.getUsuario().getIdusuario());		
		if(usuario==null){
			throw new Exception("El usuario con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
			
		
		artistaDAO.save(artista);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Artista artista) throws Exception{
		if(artista==null){
			throw new Exception("El artista no puede ser nulo");
		}
		
		
		Usuario usuario=usuarioDAO.findById((long)artista.getUsuario().getIdusuario());
		if(usuario==null){
			throw new Exception("El usuario con id: "+artista.getUsuario().getIdusuario()+" No existe");
		}
		
		artistaDAO.update(artista);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Artista artista) throws Exception {
		if(artista==null){
			throw new Exception("El Artista no puede ser nulo");
		}
		if(artista.getIdartista()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		artistaDAO.delete(artista);		
	}

	@Override
	@Transactional(readOnly=true)
	public Artista  findById(Long id) {
		return artistaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Artista> findAll() {
		return artistaDAO.findAll();
	}
}



