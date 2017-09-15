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
import com.amapearte.dao.ICaracteristicaObraDAO;
import com.amapearte.dao.IObraDAO;
import com.amapearte.modelo.Caracteristica;
import com.amapearte.modelo.CaracteristicaObra;
import com.amapearte.modelo.Obra;

@Service
@Scope("singleton")
public class CaracteristicaObraLogica implements ICaracteristicaObraLogica {
	
	@Autowired
	private ICaracteristicaDAO caracteristicaDAO;
	
	@Autowired
	private IObraDAO obraDAO;
	
	@Autowired
	private ICaracteristicaObraDAO caracteristicaObraDAO;
	
	@Autowired
	private Validator validator;

	public void validarCaracteristicaObra(CaracteristicaObra caracteristicaObra) throws Exception {
	    try {
	        Set<ConstraintViolation<CaracteristicaObra>> constraintViolations = validator.validate(caracteristicaObra);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<CaracteristicaObra> constraintViolation : constraintViolations) {
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
	public void save(CaracteristicaObra caracteristicaObra) throws Exception{
		if(caracteristicaObra==null){
			throw new Exception("La caracteristicaObra no puede ser nulo");
		}
		
		validarCaracteristicaObra(caracteristicaObra);
		
		CaracteristicaObra entity=caracteristicaObraDAO.findById((long)caracteristicaObra.getIdcaracteristicaobra());
		if(entity!=null){
			throw new Exception("La caracteristicaObra con id: "+entity.getIdcaracteristicaobra()+" Ya existe");
		}
		
		Caracteristica caracteristica=caracteristicaDAO.findById((long)caracteristicaObra.getIdcaracteristicaobra());
		if(caracteristica==null){
			throw new Exception("La caracteristica con id: "+caracteristicaObra.getCaracteristica().getIdcaracteristica()+" No existe");
		}
		
		Obra obra=obraDAO.findById((long)caracteristicaObra.getObra().getIdobra());
		if(obra==null){
			throw new Exception("La obra con id: "+entity.getObra().getIdobra()+" No existe");
		}
						
		caracteristicaObraDAO.save(caracteristicaObra);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(CaracteristicaObra caracteristicaObra) throws Exception{
		if(caracteristicaObra==null){
			throw new Exception("La caracteristicaObra no puede ser nulo");
		}		
		
		Caracteristica caracteristica=caracteristicaDAO.findById((long)caracteristicaObra.getIdcaracteristicaobra());
		if(caracteristica==null){
			throw new Exception("La caracteristica con id: "+caracteristicaObra.getCaracteristica().getIdcaracteristica()+" No existe");
		}
		
		Obra obra=obraDAO.findById((long)caracteristicaObra.getObra().getIdobra());
		if(obra==null){
			throw new Exception("La obra con id: "+caracteristicaObra.getObra().getIdobra()+" No existe");
		}
						
		caracteristicaObraDAO.update(caracteristicaObra);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(CaracteristicaObra caracteristicaObra) throws Exception{
		if(caracteristicaObra==null){
			throw new Exception("La caracteristicaObra no puede ser nulo");
		}
		
		if(caracteristicaObra.getIdcaracteristicaobra()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}					
						
		caracteristicaObraDAO.delete(caracteristicaObra);	
	}

	@Override
	@Transactional(readOnly=true)
	public CaracteristicaObra findById(Long idcaracteristicaobra) {
		return caracteristicaObraDAO.findById(idcaracteristicaobra);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CaracteristicaObra> findAll() {
		return caracteristicaObraDAO.findAll();
	}
}