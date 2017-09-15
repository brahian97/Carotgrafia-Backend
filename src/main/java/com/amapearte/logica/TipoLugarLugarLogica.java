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
import com.amapearte.dao.ILugarDAO;
import com.amapearte.dao.ITipoLugarDAO;
import com.amapearte.dao.ITipoLugarLugarDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.TipoLugarLugar;
import com.amapearte.modelo.Lugar;
import com.amapearte.modelo.TipoLugar;
import com.amapearte.modelo.TipoLugarLugar;
import com.amapearte.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amapearte.modelo.TipoLugarLugar;

@Service
@Scope("singleton")
public class TipoLugarLugarLogica implements ITipoLugarLugarLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private ITipoLugarLugarDAO tipoLugarLugarDAO;
	
	@Autowired
	private ITipoLugarDAO tipoLugarDAO;
	
	@Autowired
	private ILugarDAO lugarDAO;

	@Autowired
	private Validator validator;

	public void validarTipoLugarLugar(TipoLugarLugar tipoLugarLugar) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoLugarLugar>> constraintViolations = validator.validate(tipoLugarLugar);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoLugarLugar> constraintViolation : constraintViolations) {
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
	public void save(TipoLugarLugar tipoLugarLugar) throws Exception{
		if(tipoLugarLugar==null){
			throw new Exception("La tipo lugar lugar no puede ser nulo");
		}
		
		validarTipoLugarLugar(tipoLugarLugar);
		
		TipoLugarLugar entity=tipoLugarLugarDAO.findById((long)tipoLugarLugar.getIdtipolugarlugar());
		if(entity!=null){
			throw new Exception("El tipo lugar lugar con id: "+entity.getIdtipolugarlugar()+" Ya existe");
		}
		
		TipoLugar tlugar=tipoLugarDAO.findById((long)tipoLugarLugar.getTipoLugar().getIdtipolugar());		
		if(tlugar==null){
			throw new Exception("El tipo lugar con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		Lugar lugar=lugarDAO.findById((long)tipoLugarLugar.getLugar().getIdlugar());		
		if(lugar==null){
			throw new Exception("El lugar con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		
		tipoLugarLugarDAO.save(tipoLugarLugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoLugarLugar tipoLugarLugar) throws Exception {
		if(tipoLugarLugar==null){
			throw new Exception("La tipo lugar lugar no puede ser nulo");
		}
		
		validarTipoLugarLugar(tipoLugarLugar);
		
		TipoLugarLugar entity=tipoLugarLugarDAO.findById((long)tipoLugarLugar.getIdtipolugarlugar());
		if(entity!=null){
			throw new Exception("El tipo lugar lugar con id: "+entity.getIdtipolugarlugar()+" Ya existe");
		}
		
		TipoLugar tlugar=tipoLugarDAO.findById((long)tipoLugarLugar.getTipoLugar().getIdtipolugar());		
		if(tlugar==null){
			throw new Exception("El tipo lugar con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		Lugar lugar=lugarDAO.findById((long)tipoLugarLugar.getLugar().getIdlugar());		
		if(lugar==null){
			throw new Exception("El lugar con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		
		tipoLugarLugarDAO.update(tipoLugarLugar);	
}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoLugarLugar tipoLugarLugar)throws Exception {
		if(tipoLugarLugar==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(tipoLugarLugar.getIdtipolugarlugar()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		tipoLugarLugarDAO.delete(tipoLugarLugar);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public TipoLugarLugar findById(Long id) {
		return tipoLugarLugarDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoLugarLugar> findAll() {
		return tipoLugarLugarDAO.findAll();
	}


		}