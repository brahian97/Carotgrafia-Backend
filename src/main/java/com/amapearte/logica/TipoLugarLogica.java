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
import com.amapearte.dao.ITipoLugarDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.TipoLugar;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class TipoLugarLogica implements ITipoLugarLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private ITipoLugarDAO tipoLugarDAO;

	@Autowired
	private Validator validator;

	public void validarTipoLugar(TipoLugar tipoLugar) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoLugar>> constraintViolations = validator.validate(tipoLugar);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoLugar> constraintViolation : constraintViolations) {
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
	public void save(TipoLugar tipoLugar) throws Exception{
		if(tipoLugar==null){
			throw new Exception("el tipo lugar no puede ser nulo");
		}
		
		validarTipoLugar(tipoLugar);
		
		TipoLugar entity=tipoLugarDAO.findById((long)tipoLugar.getIdtipolugar());
		if(entity!=null){
			throw new Exception("El tipo lugar con id: "+entity.getIdtipolugar()+" Ya existe");
		}


		

		
		tipoLugarDAO.save(tipoLugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoLugar tipoLugar) throws Exception {
		if(tipoLugar==null){
			throw new Exception("el tipo lugar no puede ser nulo");
		}
		
		validarTipoLugar(tipoLugar);
		
		TipoLugar entity=tipoLugarDAO.findById((long)tipoLugar.getIdtipolugar());
		if(entity!=null){
			throw new Exception("El tipo lugar con id: "+entity.getIdtipolugar()+" Ya existe");
		}

		
		tipoLugarDAO.update(tipoLugar);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoLugar biografia)throws Exception {
		if(biografia==null){
			throw new Exception("La tipo lugar no puede ser nulo");
		}
		if(biografia.getIdtipolugar()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		tipoLugarDAO.delete(biografia);		
	}

	@Override
	@Transactional(readOnly=true)
	public TipoLugar findById(Long id) {
		return tipoLugarDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoLugar> findAll() {
		return tipoLugarDAO.findAll();
	}
}