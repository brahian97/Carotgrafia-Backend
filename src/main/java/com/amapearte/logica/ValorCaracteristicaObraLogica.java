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
import com.amapearte.dao.ICaracteristicaDAO;
import com.amapearte.dao.IValorCaracteristicaObraDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Caracteristica;
import com.amapearte.modelo.ValorCaracteristicaObra;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class ValorCaracteristicaObraLogica implements IValorCaracteristicaObraLogica {
	
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private IValorCaracteristicaObraDAO valorCaracteristicaObraDAO;

	@Autowired
	private Validator validator;
	
	@Autowired
	private ICaracteristicaDAO caracteristicaDAO;

	public void validarValorCaracteristicaObra(ValorCaracteristicaObra valorCaracteristicaObra) throws Exception {
	    try {
	        Set<ConstraintViolation<ValorCaracteristicaObra>> constraintViolations = validator.validate(valorCaracteristicaObra);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ValorCaracteristicaObra> constraintViolation : constraintViolations) {
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
	public void save(ValorCaracteristicaObra valorCaracteristicaObra) throws Exception{
		if(valorCaracteristicaObra==null){
			throw new Exception("La valor caracteristica no puede ser nulo");
		}
		
		validarValorCaracteristicaObra(valorCaracteristicaObra);
		
		ValorCaracteristicaObra entity=valorCaracteristicaObraDAO.findById((long)valorCaracteristicaObra.getIdvalorcaracteristicaobra());
		if(entity!=null){
			throw new Exception("El valor caracteristica obra con id: "+entity.getIdvalorcaracteristicaobra()+" Ya existe");
		}
		
		Caracteristica caracteristica=caracteristicaDAO.findById((long)valorCaracteristicaObra.getCaracteristica().getIdcaracteristica());		
		if(caracteristica==null){
			throw new Exception("El artista con id: "+entity.getCaracteristica().getIdcaracteristica()+" No existe");
		}
		

		
		valorCaracteristicaObraDAO.save(valorCaracteristicaObra);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ValorCaracteristicaObra valorCaracteristicaObra) throws Exception {
		if(valorCaracteristicaObra==null){
			throw new Exception("La valor caracteristica no puede ser nulo");
		}
		
		validarValorCaracteristicaObra(valorCaracteristicaObra);
		
		ValorCaracteristicaObra entity=valorCaracteristicaObraDAO.findById((long)valorCaracteristicaObra.getIdvalorcaracteristicaobra());
		if(entity!=null){
			throw new Exception("El valor caracteristica obra con id: "+entity.getIdvalorcaracteristicaobra()+" Ya existe");
		}
		
		Caracteristica caracteristica=caracteristicaDAO.findById((long)valorCaracteristicaObra.getCaracteristica().getIdcaracteristica());		
		if(caracteristica==null){
			throw new Exception("El artista con id: "+entity.getCaracteristica().getIdcaracteristica()+" No existe");
		}
		valorCaracteristicaObraDAO.update(valorCaracteristicaObra);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ValorCaracteristicaObra valorCaracteristicaObra)throws Exception {
		if(valorCaracteristicaObra==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(valorCaracteristicaObra.getIdvalorcaracteristicaobra()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		valorCaracteristicaObraDAO.delete(valorCaracteristicaObra);		
	}

	@Override
	@Transactional(readOnly=true)
	public ValorCaracteristicaObra findById(Long id) {
		return valorCaracteristicaObraDAO.findById(id);
	}

	@Override
	public List<ValorCaracteristicaObra> findAll() {
		return valorCaracteristicaObraDAO.findAll();
	}


}