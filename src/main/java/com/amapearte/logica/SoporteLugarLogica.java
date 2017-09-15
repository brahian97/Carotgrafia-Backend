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
import com.amapearte.dao.ILugarDAO;
import com.amapearte.dao.ISoporteLugarDAO;
import com.amapearte.dao.ITipoSoporteDAO;
import com.amapearte.dao.IUsuarioDAO;
import com.amapearte.modelo.Artista;
import com.amapearte.modelo.Lugar;
import com.amapearte.modelo.SoporteLugar;
import com.amapearte.modelo.TipoSoporte;
import com.amapearte.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amapearte.modelo.SoporteLugar;

@Service
@Scope("singleton")
public class SoporteLugarLogica implements ISoporteLugarLogica {
	@Autowired
	private IArtistaDAO artistaDAO;

	@Autowired
	private ISoporteLugarDAO soporteLugarDAO;
	
	@Autowired
	private ILugarDAO lugarDAO;
	
	@Autowired
	private ITipoSoporteDAO tipoSoporteDAO;
	
	@Autowired
	private Validator validator;

	public void validarSoporteLugar(SoporteLugar soporteLugar) throws Exception {
	    try {
	        Set<ConstraintViolation<SoporteLugar>> constraintViolations = validator.validate(soporteLugar);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<SoporteLugar> constraintViolation : constraintViolations) {
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
	public void save(SoporteLugar soporteLugar) throws Exception{
		if(soporteLugar==null){
			throw new Exception("La soporte lugar no puede ser nulo");
		}
		
		validarSoporteLugar(soporteLugar);
		
		SoporteLugar entity=soporteLugarDAO.findById((long)soporteLugar.getIdsoportelugar());
		if(entity!=null){
			throw new Exception("El soporte lugar con id: "+entity.getIdsoportelugar()+" Ya existe");
		}

		Lugar lugar=lugarDAO.findById((long)soporteLugar.getLugar().getIdlugar());		
		if(lugar==null){
			throw new Exception("El LUGAR con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		TipoSoporte ts=tipoSoporteDAO.findById((long)soporteLugar.getTipoSoporte().getIdtiposoporte());		
		if(ts==null){
			throw new Exception("El tipo de soporte con id: "+entity.getTipoSoporte().getIdtiposoporte()+" No existe");
		}

		
		soporteLugarDAO.save(soporteLugar);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(SoporteLugar soporteLugar) throws Exception {
		if(soporteLugar==null){
			throw new Exception("La soporte lugar no puede ser nulo");
		}
		
		validarSoporteLugar(soporteLugar);
		
		SoporteLugar entity=soporteLugarDAO.findById((long)soporteLugar.getIdsoportelugar());
		if(entity!=null){
			throw new Exception("El soporte lugar con id: "+entity.getIdsoportelugar()+" Ya existe");
		}

		Lugar lugar=lugarDAO.findById((long)soporteLugar.getLugar().getIdlugar());		
		if(lugar==null){
			throw new Exception("El LUGAR con id: "+entity.getLugar().getIdlugar()+" No existe");
		}
		
		TipoSoporte ts=tipoSoporteDAO.findById((long)soporteLugar.getTipoSoporte().getIdtiposoporte());		
		if(ts==null){
			throw new Exception("El tipo de soporte con id: "+entity.getTipoSoporte().getIdtiposoporte()+" No existe");
		}
		
		soporteLugarDAO.update(soporteLugar);		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(SoporteLugar soporteLugar)throws Exception {
		if(soporteLugar==null){
			throw new Exception("La biografia no puede ser nulo");
		}
		if(soporteLugar.getIdsoportelugar()<=0){
			throw new Exception("La identificaci�n no es permitida");
		}		

		soporteLugarDAO.delete(soporteLugar);		
	}

	@Override
	@Transactional(readOnly=true)
	public SoporteLugar findById(Long id) {
		return soporteLugarDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<SoporteLugar> findAll() {
		return soporteLugarDAO.findAll();
	}
}