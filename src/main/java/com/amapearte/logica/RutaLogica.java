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
import com.amapearte.dao.IRutaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Ruta;
import com.amapearte.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amapearte.modelo.Ruta;

@Service
@Scope("singleton")
public class RutaLogica implements IRutaLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IRutaDAO rutaDAO;
	
	@Autowired
	private IUsuarioDAO usaurioDAO;

	@Autowired
	private Validator validator;

	public void validarRuta(Ruta ruta) throws Exception {
	    try {
	        Set<ConstraintViolation<Ruta>> constraintViolations = validator.validate(ruta);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Ruta> constraintViolation : constraintViolations) {
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
	public void save(Ruta ruta) throws Exception{
		if(ruta==null){
			throw new Exception("La ruta no puede ser nulo");
		}
		
		validarRuta(ruta);
		
		Ruta entity=rutaDAO.findById((long)ruta.getIdruta());
		if(entity!=null){
			throw new Exception("El rura con id: "+entity.getIdruta()+" Ya existe");
		}
		Usuario usuario=usaurioDAO.findById((long)ruta.getUsuario().getIdusuario());		
		if(usuario==null){
			throw new Exception("El usuario con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
		

		
		rutaDAO.save(ruta);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Ruta ruta) throws Exception {
		if(ruta==null){
			throw new Exception("La ruta no puede ser nulo");
		}
		
		validarRuta(ruta);
		
		Ruta entity=rutaDAO.findById((long)ruta.getIdruta());
		if(entity!=null){
			throw new Exception("El rura con id: "+entity.getIdruta()+" Ya existe");
		}
		Usuario usuario=usaurioDAO.findById((long)ruta.getUsuario().getIdusuario());		
		if(usuario==null){
			throw new Exception("El usuario con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
		
		rutaDAO.update(ruta);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Ruta biografia)throws Exception {
		if(biografia==null){
			throw new Exception("La ruta no puede ser nulo");
		}
		if(biografia.getIdruta()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		rutaDAO.delete(biografia);		
	}

	@Override
	@Transactional(readOnly=true)
	public Ruta findById(Long id) {
		return rutaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ruta> findAll() {
		return rutaDAO.findAll();
	}
}