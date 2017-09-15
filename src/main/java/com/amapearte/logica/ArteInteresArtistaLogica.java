package com.amapearte.logica;


import java.util.List;
import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amapearte.dao.IArteInteresArtistaDAO;
import com.amapearte.dao.IArtistaDAO;
import com.amapearte.dao.IExpresionArtisticaDAO;
import com.amapearte.modelo.ArteInteresArtista;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.ExpresionArtistica;



@Service
@Scope("singleton")
public class ArteInteresArtistaLogica implements IArteInteresArtistaLogica {
	
	@Autowired
	private IArteInteresArtistaDAO arteInteresArtistaDAO;
	
	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IExpresionArtisticaDAO expresionArtisticaDAO;
	
	@Autowired
	private Validator validator;
	
	public void validarArteInteresArtista(ArteInteresArtista arteInteresArtista) throws Exception {
	    try {
	        Set<ConstraintViolation<ArteInteresArtista>> constraintViolations = validator.validate(arteInteresArtista);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<ArteInteresArtista> constraintViolation : constraintViolations) {
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
	public void save(ArteInteresArtista arteInteresArtista) throws Exception {
		if(arteInteresArtista==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		validarArteInteresArtista(arteInteresArtista);
		
		ArteInteresArtista entity=arteInteresArtistaDAO.findById((long)arteInteresArtista.getIdarteinteresartista());
		if(entity!=null){
			throw new Exception("El ArteInteresArtista con id: "+entity.getIdarteinteresartista()+" Ya existe");
		}
		Artista artista=artistaDAO.findById((long) entity.getArtista().getIdartista());
		if(artista==null){
			throw new Exception("El artista con id: "+entity.getArtista().getIdartista()+" No existe");
		}
		
		ExpresionArtistica expresionArtistica=expresionArtisticaDAO.findById((long)entity.getExpresionArtistica().getIdexpresionartistica());
		if(expresionArtistica==null){
			throw new Exception("El expresionArtistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		
		arteInteresArtistaDAO.save(arteInteresArtista);
	}
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(ArteInteresArtista arteInteresArtista) throws Exception {
		
		if(arteInteresArtista==null){
			throw new Exception("El arteInteresArtista no puede ser nulo");
		}
		validarArteInteresArtista(arteInteresArtista);
	
		
		Artista artista=artistaDAO.findById((long)arteInteresArtista.getArtista().getIdartista());
		if(artista==null){
			throw new Exception("El artista con id: "+arteInteresArtista.getArtista().getIdartista()+" No existe");
		}
		
		ExpresionArtistica expresionArtistica=expresionArtisticaDAO.findById((long)arteInteresArtista.getExpresionArtistica().getIdexpresionartistica());
		if(expresionArtistica==null){
			throw new Exception("El expresionArtistica con id: "+arteInteresArtista.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		arteInteresArtistaDAO.update(arteInteresArtista);
					
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(ArteInteresArtista arteInteresArtista) throws Exception {
		if(arteInteresArtista==null){
			throw new Exception("El arteInteresArtista no puede ser nulo");
		}
		if(arteInteresArtista.getIdarteinteresartista()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		
	
		arteInteresArtistaDAO.delete(arteInteresArtista);		
	}

	@Override
	@Transactional(readOnly=true)
	public ArteInteresArtista findById(Long id) {
		return arteInteresArtistaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ArteInteresArtista> findAll() {		
		return arteInteresArtistaDAO.findAll();
	}	
	
}
