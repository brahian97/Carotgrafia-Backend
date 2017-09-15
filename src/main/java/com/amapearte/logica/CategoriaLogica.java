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

import com.amapearte.dao.ICaracteristicaObraDAO;
import com.amapearte.dao.ICategoriaDAO;
import com.amapearte.modelo.Caracteristica;
import com.amapearte.modelo.CaracteristicaObra;
import com.amapearte.modelo.Categoria;
import com.amapearte.modelo.Obra;

@Service
@Scope("singleton")
public class CategoriaLogica implements ICategoriaLogica {
	
	@Autowired
	private ICategoriaDAO categoriaDAO;
	
	@Autowired
	private Validator validator;

	public void validarCategoria(Categoria categoria) throws Exception {
	    try {
	        Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate(categoria);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Categoria> constraintViolation : constraintViolations) {
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
	public void save(Categoria categoria) throws Exception{
		if(categoria==null){
			throw new Exception("La categoria no puede ser nulo");
		}
		
		validarCategoria(categoria);
		
		Categoria entity=categoriaDAO.findById((long)categoria.getIdcategoria());
		if(entity!=null){
			throw new Exception("La categoria con id: "+entity.getIdcategoria()+" Ya existe");
		}
							
		categoriaDAO.save(categoria);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Categoria categoria) throws Exception{
		if(categoria==null){
			throw new Exception("La categoria no puede ser nulo");
		}		
							
		categoriaDAO.update(categoria);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Categoria categoria) throws Exception{
		if(categoria==null){
			throw new Exception("La categoria no puede ser nulo");
		}
		
		if(categoria.getIdcategoria()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}	
		
		categoriaDAO.delete(categoria);	
	}

	@Override
	@Transactional(readOnly=true)
	public Categoria findById(Long idcategoria) {
		return categoriaDAO.findById(idcategoria);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {		
		return categoriaDAO.findAll();
	}
}