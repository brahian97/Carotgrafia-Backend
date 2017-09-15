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

import com.amapearte.dao.ExpresionArtisticaDAO;
import com.amapearte.dao.IArtistaDAO;
import com.amapearte.dao.IBiografiaDAO;
import com.amapearte.dao.IExpresionAutorDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;
import com.amapearte.modelo.ExpresionAutor;
import com.amapearte.modelo.ExpresionAutor;
import com.amapearte.modelo.Usuario;
@Service
@Scope("singleton")
public class ExpresionAutorLogica implements IExpresionAutorLogica {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IArtistaDAO artistaDAO;
	


	@Autowired
	private IExpresionAutorDAO expresionAutorDAO;

	@Autowired
	private Validator validator;
	
	@Autowired
	private ExpresionArtisticaDAO expresionArtisticaDAO;
	

	public void expresionAutor(ExpresionAutor expresionAutor) throws Exception {
	    try {
	        Set<ConstraintViolation<ExpresionAutor>> constraintViolations = validator.validate(expresionAutor);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ExpresionAutor> constraintViolation : constraintViolations) {
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
	public void save(ExpresionAutor expresionAutor) throws Exception{
		if(expresionAutor==null){
			throw new Exception("La expresion autor no puede ser nulo");
		}
		
		expresionAutor(expresionAutor);
	
		ExpresionAutor entity=expresionAutorDAO.findById((long)expresionAutor.getIdexpresionautor());
		if(entity!=null){
			throw new Exception("la expresion autor con  id: "+entity.getIdexpresionautor()+" Ya existe");
		}

		Artista artista=artistaDAO.findById((long)expresionAutor.getArtista().getIdartista());		
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		ExpresionArtistica ea=expresionArtisticaDAO.findById((long)expresionAutor.getExpresionArtistica().getIdexpresionartistica());		
		if(ea==null){
			throw new Exception("El expresion artistica con id: "+entity.getArtista().getIdartista()+" No existe");
		}	

	
		expresionAutorDAO.save(expresionAutor);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ExpresionAutor expresionAutor) throws Exception{
		if(expresionAutor==null){
			throw new Exception("La expresion autor no puede ser nulo");
		}
		
		expresionAutor(expresionAutor);
	
		ExpresionAutor entity=expresionAutorDAO.findById((long)expresionAutor.getIdexpresionautor());
		if(entity!=null){
			throw new Exception("la expresion autor con  id: "+entity.getIdexpresionautor()+" Ya existe");
		}

		Artista artista=artistaDAO.findById((long)expresionAutor.getArtista().getIdartista());		
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		ExpresionArtistica ea=expresionArtisticaDAO.findById((long)expresionAutor.getExpresionArtistica().getIdexpresionartistica());		
		if(ea==null){
			throw new Exception("El expresion artistica con id: "+entity.getArtista().getIdartista()+" No existe");
		}	
		
		expresionAutorDAO.update(expresionAutor);	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ExpresionAutor expresionAutor) throws Exception{
		if(expresionAutor==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(expresionAutor.getIdexpresionautor()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		expresionAutorDAO.delete(expresionAutor);		
	}

	@Override
	@Transactional(readOnly=true)
	public ExpresionAutor findById(Long idexpresionautor) {
		return expresionAutorDAO.findById(idexpresionautor);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ExpresionAutor> findAll() {
		return expresionAutorDAO.findAll();
	}
}