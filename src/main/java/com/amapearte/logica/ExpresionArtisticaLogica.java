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
import com.amapearte.dao.IExpresionArtisticaCaracteristicaDAO;
import com.amapearte.dao.IExpresionArtisticaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;
import com.amapearte.modelo.ExpresionArtistica;
import com.amapearte.modelo.ExpresionArtisticaCaracteristica;


@Service
@Scope("singleton")
public class ExpresionArtisticaLogica implements IExpresionArtisticaLogica {

	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IExpresionArtisticaCaracteristicaDAO expresionArtisticaCaracteristicaLogicaDAO;

	@Autowired
	private IExpresionArtisticaDAO expresionArtisticaDAO;

	@Autowired
	private Validator validator;

	public void validarExpresionArtistica(ExpresionArtistica expresionAristica) throws Exception {
	    try {
	        Set<ConstraintViolation<ExpresionArtistica>> constraintViolations = validator.validate(expresionAristica);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ExpresionArtistica> constraintViolation : constraintViolations) {
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
	public void save(ExpresionArtistica expresionArtistica) throws Exception{
		if(expresionArtistica==null){
			throw new Exception("La expresion artistica no puede ser nulo");
		}
		
		validarExpresionArtistica(expresionArtistica);
		ExpresionArtistica entity=expresionArtisticaDAO.findById((long)expresionArtistica.getIdexpresionartistica());
		if(entity!=null){
			throw new Exception("la expresion artistica con id: "+entity.getIdexpresionartistica()+" Ya existe");
		}
		
		expresionArtisticaDAO.save(expresionArtistica);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ExpresionArtistica expresionArtistica) throws Exception{
		if(expresionArtistica==null){
			throw new Exception("La expresion artistica no puede ser nulo");
		}
		
		validarExpresionArtistica(expresionArtistica);
		ExpresionArtistica entity=expresionArtisticaDAO.findById((long)expresionArtistica.getIdexpresionartistica());
		if(entity!=null){
			throw new Exception("la expresion artistica con id: "+entity.getIdexpresionartistica()+" Ya existe");
		}
		
		expresionArtisticaDAO.save(expresionArtistica);	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ExpresionArtistica expresionArtistica) throws Exception{
		if(expresionArtistica==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(expresionArtistica.getIdexpresionartistica()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		expresionArtisticaDAO.delete(expresionArtistica);		
	}

	@Override
	@Transactional(readOnly=true)
	public ExpresionArtistica findById(Long idexpresionartistica) {
		return expresionArtisticaDAO.findById(idexpresionartistica);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ExpresionArtistica> findAll() {
		return expresionArtisticaDAO.findAll();
	}
}