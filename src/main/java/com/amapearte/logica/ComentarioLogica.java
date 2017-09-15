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

import com.amapearte.dao.IComentarioDAO;
import com.amapearte.dao.ILugarDAO;
import com.amapearte.dao.IRutaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Categoria;
import com.amapearte.modelo.CategoriaLugar;
import com.amapearte.modelo.Comentario;
import com.amapearte.modelo.Lugar;
import com.amapearte.modelo.Ruta;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class ComentarioLogica implements IComentarioLogica {
	
	@Autowired
	private IComentarioDAO comentarioDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private IRutaDAO rutaDAO;
	
	@Autowired
	private Validator validator;
	
	public void validarComentario(Comentario comentario) throws Exception {
	    try {
	        Set<ConstraintViolation<Comentario>> constraintViolations = validator.validate(comentario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Comentario> constraintViolation : constraintViolations) {
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
	public void save(Comentario comentario) throws Exception{
		if(comentario==null){
			throw new Exception("El comentario no puede ser nulo");
		}
		
		validarComentario(comentario);
		
		Comentario entity=comentarioDAO.findById((long)comentario.getIdcomentario());
		if(entity!=null){
			throw new Exception("La categoriaLugar con id: "+entity.getIdcomentario()+" Ya existe");
		}

		Usuario usuario=usuarioDAO.findById((long)comentario.getUsuario().getIdusuario());
		if(usuario==null){
			throw new Exception("El usuario con id: "+comentario.getUsuario().getIdusuario()+" No existe");
		}
		
		Ruta ruta=rutaDAO.findById((long)comentario.getRuta().getIdruta());
		if(ruta==null){
			throw new Exception("La ruta con id: "+comentario.getRuta().getIdruta()+" No existe");
		}
		
		comentarioDAO.save(comentario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Comentario comentario) throws Exception{
		if(comentario==null){
			throw new Exception("El comentario no puede ser nulo");
		}
		
		validarComentario(comentario);
		
		Comentario entity=comentarioDAO.findById((long)comentario.getIdcomentario());
		if(entity!=null){
			throw new Exception("La categoriaLugar con id: "+entity.getIdcomentario()+" Ya existe");
		}

		Usuario usuario=usuarioDAO.findById((long)comentario.getUsuario().getIdusuario());
		if(usuario==null){
			throw new Exception("El usuario con id: "+comentario.getUsuario().getIdusuario()+" No existe");
		}
		
		Ruta ruta=rutaDAO.findById((long)comentario.getRuta().getIdruta());
		if(ruta==null){
			throw new Exception("La ruta con id: "+comentario.getRuta().getIdruta()+" Ya existe");
		}
		
		comentarioDAO.update(comentario);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Comentario comentario) throws Exception{
		if(comentario==null){
			throw new Exception("El comentario no puede ser nulo");
		}
		
		if(comentario.getIdcomentario()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}
		
		comentarioDAO.delete(comentario);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Comentario findById(Long idcomentario) {
		return comentarioDAO.findById(idcomentario);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Comentario> findAll() {
		return comentarioDAO.findAll();
	}
}