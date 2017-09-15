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
import com.amapearte.dao.ICalificacionDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;
import com.amapearte.modelo.Calificacion;

@Service
@Scope("singleton")
public class CalificacionLogica implements ICalificacionLogica {


	@Autowired
	private ICalificacionDAO calificacionDAO;

	@Autowired
	private Validator validator;

	public void validarCalificacion(Calificacion calificacion) throws Exception {
	    try {
	        Set<ConstraintViolation<Calificacion>> constraintViolations = validator.validate(calificacion);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Calificacion> constraintViolation : constraintViolations) {
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
	public void save(Calificacion calificacion) throws Exception{
		if(calificacion==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
		
		validarCalificacion(calificacion);
		
		Calificacion entity=calificacionDAO.findById((long)calificacion.getIdcalificacion());
		if(entity!=null){
			throw new Exception("La calificacion con id: "+entity.getIdcalificacion()+" Ya existe");
		}
						
		calificacionDAO.save(calificacion);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Calificacion calificacion) throws Exception{
		if(calificacion==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
				
						
		calificacionDAO.update(calificacion);	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Calificacion calificacion) throws Exception{
		if(calificacion==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
		if(calificacion.getIdcalificacion()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		calificacionDAO.delete(calificacion);	
	}

	@Override
	@Transactional(readOnly=true)
	public Calificacion findById(Long idcalificacion) {
		return calificacionDAO.findById(idcalificacion);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Calificacion> findAll() {
		return calificacionDAO.findAll();
	}
}