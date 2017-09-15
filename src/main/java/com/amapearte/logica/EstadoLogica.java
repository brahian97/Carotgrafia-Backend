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

import com.amapearte.dao.EstadoDAO;
import com.amapearte.dao.IPaisDAO;
import com.amapearte.dao.RutaDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Estado;
import com.amapearte.modelo.Estado;

import com.amapearte.modelo.Ruta;

@Service
@Scope("singleton")
public class EstadoLogica implements IEstadoLogica {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Validator validator;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	@Autowired
	private RutaDAO rutaDAO;
	
	
	public void validarEstado(Estado estado) throws Exception {
	    try {
	        Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(estado);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Estado> constraintViolation : constraintViolations) {
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
	public void save(Estado estado) throws Exception{
		if(estado==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		
		validarEstado(estado);
		
		Estado entity=estadoDAO.findById((long)estado.getIdestado());
		if(entity!=null){
			throw new Exception("El Artista con id: "+entity.getIdestado()+" Ya existe");
		}
		
		estadoDAO.save(estado);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Estado estado) throws Exception{
		if(estado==null){
			throw new Exception("El estado no puede ser nulo");
		}
		
		estadoDAO.update(estado);			
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Estado estado) throws Exception{
		if(estado==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(estado.getIdestado()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		estadoDAO.delete(estado);		
	}

	@Override
	@Transactional(readOnly=true)
	public Estado findById(Long idestado) {
		return estadoDAO.findById(idestado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Estado> findAll() {
		String jpql="SELECT est FROM Estado est";
		return estadoDAO.findAll();
	}
}