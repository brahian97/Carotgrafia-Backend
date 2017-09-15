package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Calificacion;

@Repository
@Scope("singleton")
public class CalificacionDAO implements ICalificacionDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Calificacion calificacion) {
		entityManager.persist(calificacion);
		
	}

	@Override
	public void update(Calificacion calificacion) {
		entityManager.merge(calificacion);		
		
	}

	@Override
	public void delete(Calificacion calificacion) {
		entityManager.remove(calificacion);	
		
	}

	@Override
	public Calificacion findById(Long idcalificacion) {
		return entityManager.find(Calificacion.class, idcalificacion);
	}

	@Override
	public List<Calificacion> findAll() {
		String jpql="SELECT cal FROM Calificacion cal";
		return entityManager.createQuery(jpql).getResultList();
	}
}