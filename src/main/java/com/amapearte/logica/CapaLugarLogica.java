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

import com.amapearte.dao.ICapaDAO;
import com.amapearte.dao.ICapaLugarDAO;
import com.amapearte.dao.ILugarDAO;
import com.amapearte.modelo.Capa;
import com.amapearte.modelo.CapaLugar;
import com.amapearte.modelo.Lugar;

@Service
@Scope("singleton")
public class CapaLugarLogica implements ICapaLugarLogica {
	
	@Autowired
	private ICapaDAO capaDAO;

	@Autowired
	private ILugarDAO lugarDAO;
	
	@Autowired
	private ICapaLugarDAO capaLugarDAO;
	
	@Autowired
	private Validator validator;

	public void validarCapaLugar(CapaLugar capaLugar) throws Exception {
	    try {
	        Set<ConstraintViolation<CapaLugar>> constraintViolations = validator.validate(capaLugar);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<CapaLugar> constraintViolation : constraintViolations) {
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
	public void save(CapaLugar capaLugar) throws Exception{
		if(capaLugar==null){
			throw new Exception("La calificacion no puede ser nulo");
		}
		
		validarCapaLugar(capaLugar);
		
		CapaLugar entity=capaLugarDAO.findById((long)capaLugar.getIdcapalugar());
		if(entity!=null){
			throw new Exception("La capaLugar con id: "+entity.getIdcapalugar()+" Ya existe");
		}
						
		Capa capa=capaDAO.findById((long)capaLugar.getCapa().getIdcapa());
		if(capa==null){
			throw new Exception("La capa con id: "+capa.getIdcapa()+" No existe");
		}
		
		Lugar lugar=lugarDAO.findById((long)capaLugar.getLugar().getIdlugar());
		if(lugar==null){
			throw new Exception("El lugar con id: "+capaLugar.getLugar().getIdlugar()+" No existe");
		}
		
		capaLugarDAO.save(capaLugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(CapaLugar capaLugar) throws Exception{
		if(capaLugar==null){
			throw new Exception("La calificacion no puede ser nulo");
		}		
						
		Capa capa=capaDAO.findById((long)capaLugar.getCapa().getIdcapa());
		if(capa==null){
			throw new Exception("La capa con id: "+capaLugar.getCapa().getIdcapa()+" No existe");
		}
		
		Lugar lugar=lugarDAO.findById((long)capaLugar.getLugar().getIdlugar());
		if(lugar==null){
			throw new Exception("El lugar con id: "+capaLugar.getLugar().getIdlugar()+" No existe");
		}
		
		capaLugarDAO.update(capaLugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(CapaLugar capaLugar) throws Exception{
		if(capaLugar==null){
			throw new Exception("La calificacion no puede ser nulo");
		}

		if(capaLugar.getIdcapalugar()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		
		
		capaLugarDAO.delete(capaLugar);
	}

	@Override
	@Transactional(readOnly=true)
	public CapaLugar findById(Long idcapalugar) {
		return capaLugarDAO.findById(idcapalugar);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CapaLugar> findAll() {
		return capaLugarDAO.findAll();
	}
}