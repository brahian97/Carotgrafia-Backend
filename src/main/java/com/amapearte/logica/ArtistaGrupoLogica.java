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
import com.amapearte.dao.IArtistaGrupoDAO;
import com.amapearte.dao.IGrupoDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ArtistaGrupo;
import com.amapearte.modelo.Grupo;

@Service
@Scope("singleton")
public class ArtistaGrupoLogica implements IArtistaGrupoLogica {
	
	@Autowired
	private IArtistaGrupoDAO artistaGrupoDAO;

	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IGrupoDAO grupoDAO;
	
	@Autowired
	private Validator validator;

	public void validarArtistaGrupo(ArtistaGrupo artistaGrupo) throws Exception {
	    try {
	        Set<ConstraintViolation<ArtistaGrupo>> constraintViolations = validator.validate(artistaGrupo);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ArtistaGrupo> constraintViolation : constraintViolations) {
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
	public void save(ArtistaGrupo artistaGrupo) throws Exception {
		if(artistaGrupo==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		validarArtistaGrupo(artistaGrupo);
		
		ArtistaGrupo entity=artistaGrupoDAO.findById((long)artistaGrupo.getIdartistagrupo());
		if(entity!=null){
			throw new Exception("El Artista Grupo con id: "+entity.getIdartistagrupo()+" Ya existe");
		}
		Artista artista=artistaDAO.findById((long)entity.getArtista().getIdartista());
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		Grupo grupo=grupoDAO.findById((long)entity.getGrupo().getIdgrupo());
		if(grupo==null){
			throw new Exception("El grupo con id: "+entity.getGrupo().getIdgrupo()+" No existe");
		}
		
		artistaGrupoDAO.save(artistaGrupo);
	}
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ArtistaGrupo artistaGrupo) throws Exception {
		if(artistaGrupo==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		
		Artista artista=artistaDAO.findById((long)artistaGrupo.getArtista().getIdartista());
		if(artista==null){
			throw new Exception("El artista con id: "+artistaGrupo.getArtista().getIdartista()+" No existe");
		}
		
		Grupo grupo=grupoDAO.findById((long)artistaGrupo.getGrupo().getIdgrupo());
		if(grupo==null){
			throw new Exception("El grupo con id: "+artistaGrupo.getGrupo().getIdgrupo()+" No existe");
		}
		artistaGrupoDAO.update(artistaGrupo);	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ArtistaGrupo artistaGrupo) throws Exception {
		if(artistaGrupo==null){
			throw new Exception("El arteInteresArtista no puede ser nulo");
		}
		if(artistaGrupo.getIdartistagrupo()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		artistaGrupoDAO.delete(artistaGrupo);	
	}

	@Override
	@Transactional(readOnly=true)
	public ArtistaGrupo findById(Long id) {
		return artistaGrupoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ArtistaGrupo> findAll() {
		return artistaGrupoDAO.findAll();
	}
	
	
}










