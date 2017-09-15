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
import com.amapearte.dao.ICategoriaDAO;
import com.amapearte.dao.IPaisDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.dao.PaisDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Pais;
import com.amapearte.modelo.Pais;
import com.amapearte.modelo.Pais;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class PaisLogica implements IPaisLogica {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Validator validator;
	
	@Autowired
	private IPaisDAO paisDAO;

	public void validarPais(Pais pais) throws Exception {
	    try {
	        Set<ConstraintViolation<Pais>> constraintViolations = validator.validate(pais);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Pais> constraintViolation : constraintViolations) {
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
	public void save(Pais pais) throws Exception {
		if(pais==null){
			throw new Exception("el pais no puede ser nulo");
		}
		
		validarPais(pais);
		paisDAO.save(pais);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Pais pais) throws Exception {
		if(pais==null){
			throw new Exception("El pais no puede ser nulo");
		}
		
		paisDAO.update(pais);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Pais pais)throws Exception {
		if(pais==null){
			throw new Exception("el pais no puede ser nulo");
		}
		if(pais.getIdpais()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		paisDAO.delete(pais);		
	}

	@Override
	@Transactional(readOnly=true)
	public Pais findById(Long id) {
		return paisDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pais> findAll() {
		return paisDAO.findAll();
	}
	
	
	

}