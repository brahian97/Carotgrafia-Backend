package com.amapearte.logica;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.jasper.compiler.JspUtil.ValidAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amapearte.dao.ExpresionArtisticaCaracteristicaDAO;
import com.amapearte.dao.ExpresionArtisticaDAO;
import com.amapearte.dao.IArtistaDAO;
import com.amapearte.dao.IBiografiaDAO;
import com.amapearte.dao.IExpresionArtisticaCaracteristicaDAO;
import com.amapearte.dao.IExpresionArtisticaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;
import com.amapearte.modelo.ExpresionArtisticaCaracteristica;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class ExpresionArtisticaCaracteristicaLogica implements IExpresionArtisticaCaracteristicaLogica {
	
	@Autowired
	private IExpresionArtisticaDAO expresionArtisticaDAO;

	@Autowired
	private Validator validator;
	
	@Autowired
	private IExpresionArtisticaCaracteristicaDAO expresionArtisticaCaracteristicaDAO;

	public void validarExpresionArtisticaCaracteristica(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception {
	    try {
	        Set<ConstraintViolation<ExpresionArtisticaCaracteristica>> constraintViolations = validator.validate(expresionArtisticaCaracteristica);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ExpresionArtisticaCaracteristica> constraintViolation : constraintViolations) {
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
	public void save(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception{
		if(expresionArtisticaCaracteristica==null){
			throw new Exception("La expresionArtisticaCaracteristica no puede ser nulo");
		}
		
		validarExpresionArtisticaCaracteristica(expresionArtisticaCaracteristica);
		
		ExpresionArtisticaCaracteristica entity=expresionArtisticaCaracteristicaDAO.findById((long)expresionArtisticaCaracteristica.getIdexpresionartisticacaracteristica());
		if(entity!=null){
			throw new Exception("La expresion artista caracteristica con id: "+entity.getIdexpresionartisticacaracteristica()+" Ya existe");
		}
		
		ExpresionArtistica exp=expresionArtisticaDAO.findById((long)expresionArtisticaCaracteristica.getExpresionArtistica().getIdexpresionartistica());			
		if(exp==null){
			throw new Exception("la xpresion artistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}		
	
		expresionArtisticaCaracteristicaDAO.save(expresionArtisticaCaracteristica);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception{
		if(expresionArtisticaCaracteristica==null){
			throw new Exception("La expresionArtisticaCaracteristica no puede ser nulo");
		}
		
		validarExpresionArtisticaCaracteristica(expresionArtisticaCaracteristica);
		
		ExpresionArtisticaCaracteristica entity=expresionArtisticaCaracteristicaDAO.findById((long)expresionArtisticaCaracteristica.getIdexpresionartisticacaracteristica());
		if(entity!=null){
			throw new Exception("La expresion artista caracteristica con id: "+entity.getIdexpresionartisticacaracteristica()+" Ya existe");
		}
		
		ExpresionArtistica exp=expresionArtisticaDAO.findById((long)expresionArtisticaCaracteristica.getExpresionArtistica().getIdexpresionartistica());			
		if(exp==null){
			throw new Exception("la xpresion artistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}	
		
		expresionArtisticaCaracteristicaDAO.update(expresionArtisticaCaracteristica);	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) throws Exception{
		if(expresionArtisticaCaracteristica==null){
			throw new Exception("La expresionArtisticaCaracteristica no puede ser nulo");
		}
		if(expresionArtisticaCaracteristica.getIdexpresionartisticacaracteristica()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		expresionArtisticaCaracteristicaDAO.delete(expresionArtisticaCaracteristica);	
	}

	@Override
	@Transactional(readOnly=true)
	public ExpresionArtisticaCaracteristica findById(Long idexpresionartistica) {
		return expresionArtisticaCaracteristicaDAO.findById(idexpresionartistica);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ExpresionArtisticaCaracteristica> findAll() {
		return expresionArtisticaCaracteristicaDAO.findAll();
	}
}