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
import com.amapearte.dao.IExpresionArtisticaDAO;
import com.amapearte.dao.IRutaDAO;
import com.amapearte.dao.IRutaExpresionArtisticaDAO;
import com.amapearte.dao.IRutaExpresionArtisticaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;
import com.amapearte.modelo.Ruta;
import com.amapearte.modelo.RutaExpresionArtistica;
import com.amapearte.modelo.RutaExpresionArtistica;
import com.amapearte.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amapearte.modelo.RutaExpresionArtistica;

@Service
@Scope("singleton")
public class RutaExpresionArtisticaLogica implements IRutaExpresionArtisticaLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IExpresionArtisticaDAO expresionArtisticaDAO;
	
	@Autowired
	private IRutaDAO rutaDAO;
	
	@Autowired
	private IRutaExpresionArtisticaDAO rutaExpresionArtisticaDAO;

	@Autowired
	private Validator validator;

	public void validarRutaExpresionArtistica(RutaExpresionArtistica rutaExpresionArtistica) throws Exception {
	    try {
	        Set<ConstraintViolation<RutaExpresionArtistica>> constraintViolations = validator.validate(rutaExpresionArtistica);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<RutaExpresionArtistica> constraintViolation : constraintViolations) {
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
	public void save(RutaExpresionArtistica rutaExpresionArtistica) throws Exception{
		if(rutaExpresionArtistica==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		
		validarRutaExpresionArtistica(rutaExpresionArtistica);
		
		RutaExpresionArtistica entity=rutaExpresionArtisticaDAO.findById((long)rutaExpresionArtistica.getIdrutaexpresionartistica());
		if(entity!=null){
			throw new Exception("El Artista con id: "+entity.getIdrutaexpresionartistica()+" Ya existe");
		}
		
		
		ExpresionArtistica EXP=expresionArtisticaDAO.findById((long)rutaExpresionArtistica.getExpresionArtistica().getIdexpresionartistica());		
		if(EXP==null){
			throw new Exception("El expresion artistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		
		Ruta ruta=rutaDAO.findById((long)rutaExpresionArtistica.getRuta().getIdruta());		
		if(ruta==null){
			throw new Exception("El ruta con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		

		
		rutaExpresionArtisticaDAO.save(rutaExpresionArtistica);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(RutaExpresionArtistica rutaExpresionArtistica) throws Exception {
		if(rutaExpresionArtistica==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		
		validarRutaExpresionArtistica(rutaExpresionArtistica);
		
		RutaExpresionArtistica entity=rutaExpresionArtisticaDAO.findById((long)rutaExpresionArtistica.getIdrutaexpresionartistica());
		if(entity!=null){
			throw new Exception("El Artista con id: "+entity.getIdrutaexpresionartistica()+" Ya existe");
		}
		
		
		ExpresionArtistica EXP=expresionArtisticaDAO.findById((long)rutaExpresionArtistica.getExpresionArtistica().getIdexpresionartistica());		
		if(EXP==null){
			throw new Exception("El expresion artistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		
		Ruta ruta=rutaDAO.findById((long)rutaExpresionArtistica.getRuta().getIdruta());		
		if(ruta==null){
			throw new Exception("El ruta con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		
		rutaExpresionArtisticaDAO.update(rutaExpresionArtistica);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(RutaExpresionArtistica biografia)throws Exception {
		if(biografia==null){
			throw new Exception("La ruta expresion artistica no puede ser nulo");
		}
		if(biografia.getIdrutaexpresionartistica()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		rutaExpresionArtisticaDAO.delete(biografia);		
	}

	@Override
	@Transactional(readOnly=true)
	public RutaExpresionArtistica findById(Long id) {
		return rutaExpresionArtisticaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RutaExpresionArtistica> findAll() {
		return rutaExpresionArtisticaDAO.findAll();
	}
}