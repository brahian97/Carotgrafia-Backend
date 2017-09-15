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

import com.amapearte.dao.ICategoriaDAO;
import com.amapearte.dao.ICategoriaLugarDAO;
import com.amapearte.dao.ILugarDAO;
import com.amapearte.modelo.Categoria;
import com.amapearte.modelo.CategoriaLugar;
import com.amapearte.modelo.Lugar;

@Service
@Scope("singleton")
public class CategoriaLugarLogica implements ICategoriaLugarLogica {
	
	@Autowired
	private ICategoriaDAO categoriaDAO;
	
	@Autowired
	private ICategoriaLugarDAO categoriaLugarDAO;
	
	@Autowired
	private ILugarDAO lugarDAO;
	
	@Autowired
	private Validator validator;

	public void validarCategoriaLugar(CategoriaLugar categoriaLugar) throws Exception {
	    try {
	        Set<ConstraintViolation<CategoriaLugar>> constraintViolations = validator.validate(categoriaLugar);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<CategoriaLugar> constraintViolation : constraintViolations) {
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
	public void save(CategoriaLugar categoriaLugar) throws Exception{
		if(categoriaLugar==null){
			throw new Exception("La categoriaLugar no puede ser nulo");
		}
		
		validarCategoriaLugar(categoriaLugar);
		
		CategoriaLugar entity=categoriaLugarDAO.findById((long)categoriaLugar.getIdcategorialugar());
		if(entity!=null){
			throw new Exception("La categoriaLugar con id: "+entity.getIdcategorialugar()+" Ya existe");
		}

		Lugar lugar=lugarDAO.findById((long)categoriaLugar.getLugar().getIdlugar());
		if(lugar==null){
			throw new Exception("El lugar con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		Categoria categoria=categoriaDAO.findById((long)categoriaLugar.getCategoria().getIdcategoria());
		if(categoria==null){
			throw new Exception("La categoria con id: "+entity.getCategoria().getIdcategoria()+" Ya existe");
		}
		
		categoriaLugarDAO.save(categoriaLugar);
		
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(CategoriaLugar categoriaLugar) throws Exception{
		if(categoriaLugar==null){
			throw new Exception("La categoriaLugar no puede ser nulo");
		}
		
		Lugar lugar=lugarDAO.findById((long)categoriaLugar.getLugar().getIdlugar());
		if(lugar==null){
			throw new Exception("El lugar con id: "+categoriaLugar.getLugar().getIdlugar()+" No existe");
		}
		
		Categoria categoria=categoriaDAO.findById((long)categoriaLugar.getCategoria().getIdcategoria());
		if(categoria==null){
			throw new Exception("La categoria con id: "+categoriaLugar.getCategoria().getIdcategoria()+" No existe");
		}
		categoriaLugarDAO.update(categoriaLugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(CategoriaLugar categoriaLugar) throws Exception{
		if(categoriaLugar==null){
			throw new Exception("La categoriaLugar no puede ser nulo");
		}
		
		if(categoriaLugar.getIdcategorialugar()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}
		
		categoriaLugarDAO.delete(categoriaLugar);
	}

	@Override
	@Transactional(readOnly=true)
	public CategoriaLugar findById(Long idcategorialugar) {
		return categoriaLugarDAO.findById(idcategorialugar);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CategoriaLugar> findAll() {		
		return categoriaLugarDAO.findAll();
	}
}