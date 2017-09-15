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
import com.amapearte.dao.IPaisDAO;
import com.amapearte.dao.IRolDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;
import com.amapearte.modelo.Pais;
import com.amapearte.modelo.Rol;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class UsuarioLogica implements IUsuarioLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private IPaisDAO paisDAO;
	
	@Autowired
	private IRolDAO rolDAO;

	@Autowired
	private Validator validator;
	
	public void validarUsuario(Usuario usuario) throws Exception {
	    try {
	        Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
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
	public void save(Usuario usuario) throws Exception{
		if(usuario==null){
			throw new Exception("La usuario no puede ser nulo");
		}
		
		validarUsuario(usuario);
		
		Usuario entity=usuarioDAO.findById((long)usuario.getIdusuario());
		if(entity!=null){
			throw new Exception("El usuario con id: "+entity.getIdusuario()+" Ya existe");
		}
		Pais pais=paisDAO.findById((long)usuario.getPais().getIdpais());		
		if(pais==null){
			throw new Exception("El pais con id: "+entity.getPais().getIdpais()+" No existe");
		}
		
		Rol rol=rolDAO.findById((long)usuario.getRol().getIdrol());		
		if(rol==null){
			throw new Exception("El rol con id: "+entity.getRol().getIdrol()+" No existe");
		}
		

		
		usuarioDAO.save(usuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Usuario usuario) throws Exception {
		if(usuario==null){
			throw new Exception("La usuario no puede ser nulo");
		}
		
		validarUsuario(usuario);
		
		Usuario entity=usuarioDAO.findById((long)usuario.getIdusuario());
		if(entity!=null){
			throw new Exception("El usuario con id: "+entity.getIdusuario()+" Ya existe");
		}
		Pais pais=paisDAO.findById((long)usuario.getPais().getIdpais());		
		if(pais==null){
			throw new Exception("El pais con id: "+entity.getPais().getIdpais()+" No existe");
		}
		
		Rol rol=rolDAO.findById((long)usuario.getRol().getIdrol());		
		if(rol==null){
			throw new Exception("El rol con id: "+entity.getRol().getIdrol()+" No existe");
		}
		
		usuarioDAO.update(usuario);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Usuario usuario)throws Exception {
		if(usuario==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(usuario.getIdusuario()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		usuarioDAO.delete(usuario);		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long id) {
		return usuarioDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return usuarioDAO.findAll();
	}
}