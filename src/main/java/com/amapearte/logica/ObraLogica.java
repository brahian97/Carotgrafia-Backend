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
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.Obra;

@Service
@Scope("singleton")
public class ObraLogica implements IObraLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IObraDAO obraDAO;


	@Autowired
	private Validator validator;

	public void validarObra(Obra obra) throws Exception {
	    try {
	        Set<ConstraintViolation<Obra>> constraintViolations = validator.validate(obra);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Obra> constraintViolation : constraintViolations) {
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
	public void save(Obra obra) throws Exception{
		if(obra==null){
			throw new Exception("La obra no puede ser nulo");
		}
		
		validarObra(obra);
		
		Obra entity=obraDAO.findById((long)obra.getIdobra());
		if(entity!=null){
			throw new Exception("la obra con id: "+entity.getIdobra()+" Ya existe");
		}
		
		obraDAO.save(obra);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Obra obra) throws Exception {
		if(obra==null){
			throw new Exception("La obra no puede ser nulo");
		}
		
		validarObra(obra);
		
		Obra entity=obraDAO.findById((long)obra.getIdobra());
		if(entity!=null){
			throw new Exception("la obra con id: "+entity.getIdobra()+" Ya existe");
		}
		
		obraDAO.update(obra);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Obra obra)throws Exception {
		if(obra==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(obra.getIdobra()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		obraDAO.delete(obra);		
	}

	@Override
	@Transactional(readOnly=true)
	public Obra findById(Long id) {
		return obraDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Obra> findAll() {
		return obraDAO.findAll();
	}
}