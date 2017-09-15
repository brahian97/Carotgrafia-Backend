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

import com.amapearte.dao.GrupoDAO;
import com.amapearte.dao.IArtistaDAO;
import com.amapearte.dao.IBiografiaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Grupo;
import com.amapearte.modelo.Grupo;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class GrupoLogica implements IGrupoLogica {
	
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private GrupoDAO grupoDAO;

	@Autowired
	private Validator validator;

	public void validarGrupo(Grupo grupo) throws Exception {
	    try {
	        Set<ConstraintViolation<Grupo>> constraintViolations = validator.validate(grupo);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Grupo> constraintViolation : constraintViolations) {
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
	public void save(Grupo grupo) throws Exception{
		if(grupo==null){
			throw new Exception("el grupo no puede ser nulo");
		}
		
		validarGrupo(grupo);
		
		Grupo entity=grupoDAO.findById((long)grupo.getIdgrupo());
		if(entity!=null){
			throw new Exception("El grupo con id: "+entity.getIdgrupo()+" Ya existe");
		}
		grupoDAO.save(grupo);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Grupo grupo) throws Exception{
		if(grupo==null){
			throw new Exception("el grupo no puede ser nulo");
		}
		
		validarGrupo(grupo);
		
		Grupo entity=grupoDAO.findById((long)grupo.getIdgrupo());
		if(entity!=null){
			throw new Exception("El grupo con id: "+entity.getIdgrupo()+" Ya existe");
		}
		grupoDAO.update(grupo);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Grupo grupo) throws Exception{
		if(grupo==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(grupo.getIdgrupo()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		grupoDAO.delete(grupo);	
	}

	@Override
	@Transactional(readOnly=true)
	public Grupo findById(Long idgrupo) {
		return grupoDAO.findById(idgrupo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Grupo> findAll() {
		return grupoDAO.findAll();
	}
}