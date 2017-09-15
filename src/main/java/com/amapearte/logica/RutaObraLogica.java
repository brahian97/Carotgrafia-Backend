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
import com.amapearte.dao.IObraDAO;
import com.amapearte.dao.IRutaDAO;
import com.amapearte.dao.IRutaObraDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.Ruta;
import com.amapearte.modelo.RutaObra;
import com.amapearte.modelo.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amapearte.modelo.RutaObra;

@Service
@Scope("singleton")
public class RutaObraLogica implements IRutaObraLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IRutaObraDAO rutaObraDAO;
	
	@Autowired
	private IRutaDAO rutaDAO;
	
	@Autowired
	private IObraDAO obraDAO;

	@Autowired
	private Validator validator;

	public void validarRutaObra(RutaObra ruraObra) throws Exception {
	    try {
	        Set<ConstraintViolation<RutaObra>> constraintViolations = validator.validate(ruraObra);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<RutaObra> constraintViolation : constraintViolations) {
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
	public void save(RutaObra rutaObra) throws Exception{
		if(rutaObra==null){
			throw new Exception("La ruta obra no puede ser nulo");
		}
		
		validarRutaObra(rutaObra);
		
		RutaObra entity=rutaObraDAO.findById((long)rutaObra.getIdrutaobra());
		if(entity!=null){
			throw new Exception("El ruta obra con id: "+entity.getIdrutaobra()+" Ya existe");
		}
		
		Ruta ruta=rutaDAO.findById((long)rutaObra.getRuta().getIdruta());		
		if(ruta==null){
			throw new Exception("El ruta con id: "+entity.getRuta().getIdruta()+" No existe");
		}
		
		Obra obra=obraDAO.findById((long)rutaObra.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("El obra con id: "+entity.getRuta().getIdruta()+" No existe");
		}
		

		
		rutaObraDAO.save(rutaObra);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(RutaObra rutaObra) throws Exception {
		if(rutaObra==null){
			throw new Exception("La ruta obra no puede ser nulo");
		}
		
		validarRutaObra(rutaObra);
		
		RutaObra entity=rutaObraDAO.findById((long)rutaObra.getIdrutaobra());
		if(entity!=null){
			throw new Exception("El ruta obra con id: "+entity.getIdrutaobra()+" Ya existe");
		}
		
		Ruta ruta=rutaDAO.findById((long)rutaObra.getRuta().getIdruta());		
		if(ruta==null){
			throw new Exception("El ruta con id: "+entity.getRuta().getIdruta()+" No existe");
		}
		
		Obra obra=obraDAO.findById((long)rutaObra.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("El obra con id: "+entity.getRuta().getIdruta()+" No existe");
		}
		
		
		rutaObraDAO.update(rutaObra);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(RutaObra biografia)throws Exception {
		if(biografia==null){
			throw new Exception("La ruta obra no puede ser nulo");
		}
		if(biografia.getIdrutaobra()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		rutaObraDAO.delete(biografia);		
	}

	@Override
	@Transactional(readOnly=true)
	public RutaObra findById(Long id) {
		return rutaObraDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RutaObra> findAll() {
		return rutaObraDAO.findAll();
	}
}