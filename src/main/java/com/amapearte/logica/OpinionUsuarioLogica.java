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
import com.amapearte.dao.IOpinionUsuarioDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.OpinionUsuario;
import com.amapearte.modelo.Usuario;
import com.amapearte.modelo.OpinionUsuario;

@Service
@Scope("singleton")
public class OpinionUsuarioLogica implements IOpinionUsuarioLogica {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Autowired
	private IOpinionUsuarioDAO opinionUsuarioDAO;

	@Autowired
	private Validator validator;

	public void validarOpinionUsuario(OpinionUsuario opinionUsuario) throws Exception {
	    try {
	        Set<ConstraintViolation<OpinionUsuario>> constraintViolations = validator.validate(opinionUsuario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<OpinionUsuario> constraintViolation : constraintViolations) {
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
	public void save(OpinionUsuario opinionUsuario) throws Exception{
		if(opinionUsuario==null){
			throw new Exception("La opinion usuario no puede ser nulo");
		}
		
		validarOpinionUsuario(opinionUsuario);
		
		OpinionUsuario entity=opinionUsuarioDAO.findById((long)opinionUsuario.getIdopinionusuario());
		if(entity!=null){
			throw new Exception("la opinion usuario con id: "+entity.getIdopinionusuario()+" Ya existe");
		}
		
		Usuario usu=usuarioDAO.findById((long)opinionUsuario.getUsuario().getIdusuario());		
		if(usu==null){
			throw new Exception("El artista con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
		

		
		opinionUsuarioDAO.save(opinionUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(OpinionUsuario opinionUsuario) throws Exception {
		if(opinionUsuario==null){
			throw new Exception("La opinion usuario no puede ser nulo");
		}
		
		validarOpinionUsuario(opinionUsuario);
		
		OpinionUsuario entity=opinionUsuarioDAO.findById((long)opinionUsuario.getIdopinionusuario());
		if(entity!=null){
			throw new Exception("la opinion usuario con id: "+entity.getIdopinionusuario()+" Ya existe");
		}
		
		Usuario usu=usuarioDAO.findById((long)opinionUsuario.getUsuario().getIdusuario());		
		if(usu==null){
			throw new Exception("El artista con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
		

		
		opinionUsuarioDAO.update(opinionUsuario);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(OpinionUsuario opinionUsuario)throws Exception {
		if(opinionUsuario==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(opinionUsuario.getIdopinionusuario()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		opinionUsuarioDAO.delete(opinionUsuario);		
	}

	@Override
	@Transactional(readOnly=true)
	public OpinionUsuario findById(Long id) {
		return opinionUsuarioDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OpinionUsuario> findAll() {
		return opinionUsuarioDAO.findAll();
	}
	
}