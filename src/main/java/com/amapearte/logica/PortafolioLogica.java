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
import com.amapearte.dao.IObraDAO;
import com.amapearte.dao.IPortafolioDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.Portafolio;

import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class PortafolioLogica implements IPortafolioLogica {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	
	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IObraDAO obraDAO;

	@Autowired
	private IPortafolioDAO portafolioDAO;

	@Autowired
	private Validator validator;

	public void validarPortafolio(Portafolio portafolio) throws Exception {
	    try {
	        Set<ConstraintViolation<Portafolio>> constraintViolations = validator.validate(portafolio);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Portafolio> constraintViolation : constraintViolations) {
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
	public void save(Portafolio portafolio) throws Exception{
		if(portafolio==null){
			throw new Exception("el portafolio nu puede ser nulo");
		}
		
		validarPortafolio(portafolio);
		
		Portafolio entity=portafolioDAO.findById((long)portafolio.getIdportafolio());
		if(entity!=null){
			throw new Exception("El portafolio con id: "+portafolio.getIdportafolio()+" Ya existe");
		}
		
		Artista artista=artistaDAO.findById((long)portafolio.getArtista().getIdartista());		
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		Obra obra=obraDAO.findById((long)portafolio.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("la obra  con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		
		portafolioDAO.save(portafolio);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Portafolio portafolio) throws Exception {
		if(portafolio==null){
			throw new Exception("el portafolio nu puede ser nulo");
		}
		
		validarPortafolio(portafolio);
		
		Portafolio entity=portafolioDAO.findById((long)portafolio.getIdportafolio());
		if(entity!=null){
			throw new Exception("El portafolio con id: "+portafolio.getIdportafolio()+" Ya existe");
		}
		
		Artista artista=artistaDAO.findById((long)portafolio.getArtista().getIdartista());		
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		Obra obra=obraDAO.findById((long)portafolio.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("la obra  con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		
		portafolioDAO.update(portafolio);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Portafolio biografia)throws Exception {
		if(biografia==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(biografia.getIdportafolio()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		portafolioDAO.delete(biografia);		
	}

	@Override
	@Transactional(readOnly=true)
	public Portafolio findById(Long id) {
		return portafolioDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Portafolio> findAll() {
		return portafolioDAO.findAll();
	}
}