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
import com.amapearte.dao.ILugarDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Lugar;
import com.amapearte.modelo.Lugar;

@Service
@Scope("singleton")
public class LugarLogica implements ILugarLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private ILugarDAO LugarDAO;

	@Autowired
	private Validator validator;

	public void validarLugar(Lugar lugar) throws Exception {
	    try {
	        Set<ConstraintViolation<Lugar>> constraintViolations = validator.validate(lugar);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Lugar> constraintViolation : constraintViolations) {
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
	public void save(Lugar lugar) throws Exception{
		if(lugar==null){
			throw new Exception("el lugar no puede ser nulo");
		}
		
		validarLugar(lugar);
		
		Lugar entity=LugarDAO.findById((long)lugar.getIdlugar());
		if(entity!=null){
			throw new Exception("El lugar con id: "+entity.getIdlugar()+" Ya existe");
		}

		LugarDAO.save(lugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Lugar lugar) throws Exception {
		if(lugar==null){
			throw new Exception("el lugar no puede ser nulo");
		}
		
		validarLugar(lugar);
		
		Lugar entity=LugarDAO.findById((long)lugar.getIdlugar());
		if(entity!=null){
			throw new Exception("El lugar con id: "+entity.getIdlugar()+" Ya existe");
		}
		
		LugarDAO.update(lugar);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Lugar lugar)throws Exception {
		if(lugar==null){
			throw new Exception("el lugar no puede ser nulo");
		}
		if(lugar.getIdlugar()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		LugarDAO.delete(lugar);		
	}

	@Override
	@Transactional(readOnly=true)
	public Lugar findById(Long id) {
		return LugarDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Lugar> findAll() {
		return LugarDAO.findAll();
	}
}