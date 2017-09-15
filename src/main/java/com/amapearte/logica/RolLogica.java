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
import com.amapearte.dao.IRolDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Rol;
import com.amapearte.modelo.Rol;
import com.amapearte.modelo.Usuario;


@Service
@Scope("singleton")
public class RolLogica implements IRolLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IRolDAO rolDAO;

	@Autowired
	private Validator validator;

	public void validarRol(Rol rol) throws Exception {
	    try {
	        Set<ConstraintViolation<Rol>> constraintViolations = validator.validate(rol);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Rol> constraintViolation : constraintViolations) {
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
	public void save(Rol rol) throws Exception{
		if(rol==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		
		validarRol(rol);
		
		Rol entity=rolDAO.findById((long)rol.getIdrol());
		if(entity!=null){
			throw new Exception("El rol con id: "+entity.getIdrol()+" Ya existe");
		}
		
		
		rolDAO.save(rol);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Rol rol) throws Exception {
		if(rol==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		
		validarRol(rol);
		
		Rol entity=rolDAO.findById((long)rol.getIdrol());
		if(entity!=null){
			throw new Exception("El rol con id: "+entity.getIdrol()+" Ya existe");
		}
		
		
		rolDAO.update(rol);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Rol rol)throws Exception {
		if(rol==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(rol.getIdrol()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		rolDAO.delete(rol);		
	}

	@Override
	@Transactional(readOnly=true)
	public Rol findById(Long id) {
		return rolDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Rol> findAll() {
		return rolDAO.findAll();
	}
}