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

import com.amapearte.dao.ICalificacionDAO;
import com.amapearte.dao.ICapaDAO;
import com.amapearte.modelo.Calificacion;
import com.amapearte.modelo.Capa;

@Service
@Scope("singleton")
public class CapaLogica implements ICapaLogica {
	
	@Autowired
	private ICapaDAO capaDAO;

	@Autowired
	private Validator validator;

	public void validarCapa(Capa capa) throws Exception {
	    try {
	        Set<ConstraintViolation<Capa>> constraintViolations = validator.validate(capa);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Capa> constraintViolation : constraintViolations) {
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
	public void save(Capa capa) throws Exception{
		if(capa==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
		
		validarCapa(capa);
		
		Capa entity=capaDAO.findById((long)capa.getIdcapa());
		if(entity!=null){
			throw new Exception("La capa con id: "+entity.getIdcapa()+" Ya existe");
		}
						
		capaDAO.save(capa);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Capa capa) throws Exception{
		if(capa==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
		
						
		capaDAO.update(capa);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Capa capa) throws Exception{
		if(capa==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
		
		validarCapa(capa);
				
		
		if(capa.getIdcapa()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		
						
		capaDAO.delete(capa);
	}

	@Override
	@Transactional(readOnly=true)
	public Capa findById(Long idcapa) {
		return capaDAO.findById(idcapa);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Capa> findAll() {
		return capaDAO.findAll();
	}
}