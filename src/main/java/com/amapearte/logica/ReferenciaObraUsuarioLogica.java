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
import com.amapearte.dao.IObraDAO;
import com.amapearte.dao.IReferenciaObraUsuarioDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Obra;
import com.amapearte.modelo.ReferenciaObraUsuario;
import com.amapearte.modelo.Usuario;
import com.amapearte.modelo.ReferenciaObraUsuario;

@Service
@Scope("singleton")
public class ReferenciaObraUsuarioLogica implements IReferenciaObraUsuarioLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IObraDAO obraDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Autowired
	private IReferenciaObraUsuarioDAO referenciaObraUsuarioDAO;

	@Autowired
	private Validator validator;

	public void validarReferenciaObraUsuario(ReferenciaObraUsuario referenciaObraUsuario) throws Exception {
	    try {
	        Set<ConstraintViolation<ReferenciaObraUsuario>> constraintViolations = validator.validate(referenciaObraUsuario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ReferenciaObraUsuario> constraintViolation : constraintViolations) {
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
	public void save(ReferenciaObraUsuario referenciaObraUsuario) throws Exception{
		if(referenciaObraUsuario==null){
			throw new Exception("La referencia obra usuario no puede ser nulo");
		}
		
		validarReferenciaObraUsuario(referenciaObraUsuario);
		
		ReferenciaObraUsuario entity=referenciaObraUsuarioDAO.findById((long)referenciaObraUsuario.getIdreferenciaobrausuario());
		if(entity!=null){
			throw new Exception("El referencia obra usuario id: "+entity.getIdreferenciaobrausuario()+" Ya existe");
		}
		

		Obra obra=obraDAO.findById((long)referenciaObraUsuario.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("la obra con id: "+entity.getObra().getIdobra()+" No existe");
		}
		
		Usuario usuario=usuarioDAO.findById((long)referenciaObraUsuario.getUsuario().getIdusuario());		
		if(usuario==null){
			throw new Exception("el usuario con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
		

		
		referenciaObraUsuarioDAO.save(referenciaObraUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ReferenciaObraUsuario referenciaObraUsuario) throws Exception {
		if(referenciaObraUsuario==null){
			throw new Exception("La referencia obra usuario no puede ser nulo");
		}
		
		validarReferenciaObraUsuario(referenciaObraUsuario);
		
		ReferenciaObraUsuario entity=referenciaObraUsuarioDAO.findById((long)referenciaObraUsuario.getIdreferenciaobrausuario());
		if(entity!=null){
			throw new Exception("El referencia obra usuario id: "+entity.getIdreferenciaobrausuario()+" Ya existe");
		}
		

		Obra obra=obraDAO.findById((long)referenciaObraUsuario.getObra().getIdobra());		
		if(obra==null){
			throw new Exception("la obra con id: "+entity.getObra().getIdobra()+" No existe");
		}
		
		Usuario usuario=usuarioDAO.findById((long)referenciaObraUsuario.getUsuario().getIdusuario());		
		if(usuario==null){
			throw new Exception("el usuario con id: "+entity.getUsuario().getIdusuario()+" No existe");
		}
		
		referenciaObraUsuarioDAO.update(referenciaObraUsuario);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ReferenciaObraUsuario referenciaObraUsuario)throws Exception {
		if(referenciaObraUsuario==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(referenciaObraUsuario.getIdreferenciaobrausuario()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		referenciaObraUsuarioDAO.delete(referenciaObraUsuario);		
	}

	@Override
	@Transactional(readOnly=true)
	public ReferenciaObraUsuario findById(Long id) {
		return referenciaObraUsuarioDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ReferenciaObraUsuario> findAll() {
		return referenciaObraUsuarioDAO.findAll();
	}
}