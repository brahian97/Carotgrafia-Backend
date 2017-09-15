package com.amapearte.logica;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amapearte.dao.IArtistaDAO;
import com.amapearte.dao.IBiografiaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class BiografiaLogica implements IBiografiaLogica {

	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IBiografiaDAO biografiaDAO;

	@Autowired
	private Validator validator;

	public void validarBiografia(Biografia biografia) throws Exception {
	    try {
	        Set<ConstraintViolation<Biografia>> constraintViolations = validator.validate(biografia);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Biografia> constraintViolation : constraintViolations) {
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
	public void save(Biografia biografia) throws Exception{
		if(biografia==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		
		validarBiografia(biografia);
		
		Biografia entity=biografiaDAO.findById((long)biografia.getIdbiografia());
		if(entity!=null){
			throw new Exception("El Artista con id: "+entity.getIdbiografia()+" Ya existe");
		}
		
		Artista artista=artistaDAO.findById((long)biografia.getArtista().getIdartista());		
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		

		
		biografiaDAO.save(biografia);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Biografia biografia) throws Exception {
		if(biografia==null){
			throw new Exception("El biografia no puede ser nulo");
		}
		
		Artista artista=artistaDAO.findById((long)biografia.getArtista().getIdartista());		
		if(artista==null){
			throw new Exception("El artista con id: "+biografia.getArtista().getIdartista()+" No existe");
		}
		
		biografiaDAO.update(biografia);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Biografia biografia)throws Exception {
		if(biografia==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(biografia.getIdbiografia()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		biografiaDAO.delete(biografia);		
	}

	@Override
	@Transactional(readOnly=true)
	public Biografia findById(Long id) {
		return biografiaDAO.findById(id);
	}

	@Override
	public List<Biografia> findAll() {
		return biografiaDAO.findAll();
	}



}




