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


import com.amapearte.dao.ICaracteristicaDAO;
import com.amapearte.modelo.Caracteristica;


@Service
@Scope("singleton")
public class CaracteristicaLogica implements ICaracteristicaLogica {
	
	
	@Autowired
	private ICaracteristicaDAO caracteristicaDAO;
	
	@Autowired
	private Validator validator;

	public void validarCaracteristica(Caracteristica caracteristica) throws Exception {
	    try {
	        Set<ConstraintViolation<Caracteristica>> constraintViolations = validator.validate(caracteristica);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Caracteristica> constraintViolation : constraintViolations) {
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
	public void save(Caracteristica caracteristica) throws Exception{
		if(caracteristica==null){
			throw new Exception("La caracteristica no puede ser nulo");
		}
		
		validarCaracteristica(caracteristica);
		
		Caracteristica entity=caracteristicaDAO.findById((long)caracteristica.getIdcaracteristica());
		if(entity!=null){
			throw new Exception("La caracteristica con id: "+entity.getIdcaracteristica()+" Ya existe");
		}
						
		caracteristicaDAO.save(caracteristica);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Caracteristica caracteristica) throws Exception{
		if(caracteristica==null){
			throw new Exception("La caracteristica no puede ser nulo");
		}		
						
		caracteristicaDAO.update(caracteristica);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Caracteristica caracteristica) throws Exception{
		if(caracteristica==null){
			throw new Exception("La caracteristica no puede ser nulo");
		}
		
		if(caracteristica.getIdcaracteristica()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		
						
		caracteristicaDAO.delete(caracteristica);			
	}

	@Override
	@Transactional(readOnly=true)
	public Caracteristica findById(Long idcaracteristica) {
		return caracteristicaDAO.findById(idcaracteristica);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Caracteristica> findAll() {
		return caracteristicaDAO.findAll();
	}
}