package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Estado;

@Repository
@Scope("singleton")
public class EstadoDAO implements IEstadoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Estado estado) {
		entityManager.persist(estado);
	}

	@Override
	public void update(Estado estado) {
		entityManager.merge(estado);		
	}

	@Override
	public void delete(Estado estado) {
		entityManager.remove(estado);	
	}

	@Override
	public Estado findById(Long idestado) {
		return entityManager.find(Estado.class, idestado);
	}

	@Override
	public List<Estado> findAll() {
		String jpql="SELECT est FROM Estado est";
		return entityManager.createQuery(jpql).getResultList();
	}
}