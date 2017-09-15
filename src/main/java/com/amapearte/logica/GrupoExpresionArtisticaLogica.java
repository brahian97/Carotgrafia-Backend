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
import com.amapearte.dao.IExpresionArtisticaDAO;
import com.amapearte.dao.IGrupoExpresionArtisticaDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Biografia;
import com.amapearte.modelo.ExpresionArtistica;
import com.amapearte.modelo.GrupoExpresionArtistica;
import com.amapearte.modelo.Usuario;

@Service
@Scope("singleton")
public class GrupoExpresionArtisticaLogica implements IGrupoExpresionArtisticaLogica {
	


	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IArtistaDAO artistaDAO;
	
	@Autowired
	private IGrupoExpresionArtisticaDAO grupoExpresionArtisticaDAO;

	@Autowired
	private IExpresionArtisticaDAO expresionArtisticaDAO;

	@Autowired
	private Validator validator;

	public void validarGrupoExpresionArtistica(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception {
	    try {
	        Set<ConstraintViolation<GrupoExpresionArtistica>> constraintViolations = validator.validate(grupoExpresionArtistica);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<GrupoExpresionArtistica> constraintViolation : constraintViolations) {
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
	public void save(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception{
		if(grupoExpresionArtistica==null){
			throw new Exception(" el frupo expresion artistica no puede ser nulo");
		}
		
		validarGrupoExpresionArtistica(grupoExpresionArtistica);
		
		GrupoExpresionArtistica entity=grupoExpresionArtisticaDAO.findById((long)grupoExpresionArtistica.getIdgrupoexpresionartistica());
		if(entity!=null){
			throw new Exception("El grupo exprresion artistica id: "+entity.getIdgrupoexpresionartistica()+" Ya existe");
		}
		
		ExpresionArtistica ep=expresionArtisticaDAO.findById((long)grupoExpresionArtistica.getExpresionArtistica().getIdexpresionartistica());		
		if(ep==null){
			throw new Exception("la expresion asrtistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
		

		
		grupoExpresionArtisticaDAO.save(grupoExpresionArtistica);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception{
		if(grupoExpresionArtistica==null){
			throw new Exception(" el frupo expresion artistica no puede ser nulo");
		}
		
		validarGrupoExpresionArtistica(grupoExpresionArtistica);
		
		GrupoExpresionArtistica entity=grupoExpresionArtisticaDAO.findById((long)grupoExpresionArtistica.getIdgrupoexpresionartistica());
		if(entity!=null){
			throw new Exception("El grupo exprresion artistica id: "+entity.getIdgrupoexpresionartistica()+" Ya existe");
		}
		
		ExpresionArtistica ep=expresionArtisticaDAO.findById((long)grupoExpresionArtistica.getExpresionArtistica().getIdexpresionartistica());		
		if(ep==null){
			throw new Exception("la expresion asrtistica con id: "+entity.getExpresionArtistica().getIdexpresionartistica()+" No existe");
		}
			grupoExpresionArtisticaDAO.update(grupoExpresionArtistica);	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(GrupoExpresionArtistica grupoExpresionArtistica) throws Exception{
		if(grupoExpresionArtistica==null){
			throw new Exception("el grupoexpresionartistica no puede ser nulo");
		}
		if(grupoExpresionArtistica.getIdgrupoexpresionartistica()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		grupoExpresionArtisticaDAO.delete(grupoExpresionArtistica);		
	}

	@Override
	@Transactional(readOnly=true)
	public GrupoExpresionArtistica findById(Long id) {
		return grupoExpresionArtisticaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<GrupoExpresionArtistica> findAll() {
		String jpql="SELECT gruExpA FROM GrupoExpresionArtistica gruExpA";
		return grupoExpresionArtisticaDAO.findAll();
	}
}