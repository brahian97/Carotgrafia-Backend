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
import com.amapearte.dao.ITipoSoporteDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.TipoSoporte;
import com.amapearte.modelo.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amapearte.modelo.TipoSoporte;

@Service
@Scope("singleton")
public class TipoSoporteLogica implements ITipoSoporteLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private ITipoSoporteDAO tipoSoporteDAO;

	@Autowired
	private Validator validator;

	public void validarTipoSoporte(TipoSoporte tipoSoporte) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoSoporte>> constraintViolations = validator.validate(tipoSoporte);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoSoporte> constraintViolation : constraintViolations) {
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
	public void save(TipoSoporte tipoSoporte) throws Exception{
		if(tipoSoporte==null){
			throw new Exception("La tipo de soporte no puede ser nulo");
		}
		
		validarTipoSoporte(tipoSoporte);
		
		TipoSoporte entity=tipoSoporteDAO.findById((long)tipoSoporte.getIdtiposoporte());
		if(entity!=null){
			throw new Exception("El tipo de soporte con id: "+entity.getIdtiposoporte()+" Ya existe");
		}
		
		
		tipoSoporteDAO.save(tipoSoporte);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoSoporte tipoSoporte) throws Exception {
		if(tipoSoporte==null){
			throw new Exception("La tipo de soporte no puede ser nulo");
		}
		
		validarTipoSoporte(tipoSoporte);
		
		TipoSoporte entity=tipoSoporteDAO.findById((long)tipoSoporte.getIdtiposoporte());
		if(entity!=null){
			throw new Exception("El tipo de soporte con id: "+entity.getIdtiposoporte()+" Ya existe");
		}
		
		tipoSoporteDAO.update(tipoSoporte);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoSoporte usuario)throws Exception {
		if(usuario==null){
			throw new Exception("La tipo soporte no puede ser nulo");
		}
		if(usuario.getIdtiposoporte()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		tipoSoporteDAO.delete(usuario);		
	}

	@Override
	@Transactional(readOnly=true)
	public TipoSoporte findById(Long id) {
		return tipoSoporteDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoSoporte> findAll() {
		return tipoSoporteDAO.findAll();
	}
}