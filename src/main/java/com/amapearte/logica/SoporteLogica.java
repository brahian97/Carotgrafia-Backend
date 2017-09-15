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
import com.amapearte.dao.ISoporteDAO;
import com.amapearte.dao.ITipoSoporteDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.Soporte;
import com.amapearte.modelo.TipoSoporte;
import com.amapearte.modelo.Usuario;


@Service
@Scope("singleton")
public class SoporteLogica implements ISoporteLogica {
	

	

	@Autowired
	private ISoporteDAO soporteDAO;
	
	@Autowired
	private IObraDAO obraDAO;
	
	@Autowired
	private ITipoSoporteDAO tipoSoporteDAO;

	@Autowired
	private Validator validator;

	public void validarSoporte(Soporte soporte) throws Exception {
	    try {
	        Set<ConstraintViolation<Soporte>> constraintViolations = validator.validate(soporte);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Soporte> constraintViolation : constraintViolations) {
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
	public void save(Soporte soporte) throws Exception{
		if(soporte==null){
			throw new Exception("La soporte no puede ser nulo");
		}
		
		validarSoporte(soporte);
		
		Soporte entity=soporteDAO.findById((long)soporte.getIdsoporte());
		if(entity!=null){
			throw new Exception("El soporte con id: "+entity.getIdsoporte()+" Ya existe");
		}

		Obra obra=obraDAO.findById((long)soporte.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("El obra con id: "+entity.getObra().getIdobra()+" No existe");
		}
		
		TipoSoporte ts=tipoSoporteDAO.findById((long)soporte.getTipoSoporte().getIdtiposoporte());		
		if(ts==null){
			throw new Exception("El tipo de soporte con id: "+entity.getTipoSoporte().getIdtiposoporte()+" No existe");
		}
		
		
		soporteDAO.save(soporte);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Soporte soporte) throws Exception {
		if(soporte==null){
			throw new Exception("La soporte no puede ser nulo");
		}
		
		validarSoporte(soporte);
		
		Soporte entity=soporteDAO.findById((long)soporte.getIdsoporte());
		if(entity!=null){
			throw new Exception("El soporte con id: "+entity.getIdsoporte()+" Ya existe");
		}

		Obra obra=obraDAO.findById((long)soporte.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("El obra con id: "+entity.getObra().getIdobra()+" No existe");
		}
		
		TipoSoporte ts=tipoSoporteDAO.findById((long)soporte.getTipoSoporte().getIdtiposoporte());		
		if(ts==null){
			throw new Exception("El tipo de soporte con id: "+entity.getTipoSoporte().getIdtiposoporte()+" No existe");
		}
		

		soporteDAO.delete(soporte);		
	}

	@Override
	@Transactional(readOnly=true)
	public Soporte findById(Long id) {
		return soporteDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Soporte> findAll() {
		return soporteDAO.findAll();
	}

	@Override
	public void delete(Soporte soporte) throws Exception {
		if(soporte==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(soporte.getIdsoporte()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		soporteDAO.delete(soporte);	
		
	}
	
}