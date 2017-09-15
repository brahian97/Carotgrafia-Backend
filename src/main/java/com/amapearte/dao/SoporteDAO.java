package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Soporte;

@Repository
@Scope("singleton")
public class SoporteDAO implements ISoporteDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Soporte soporte) {
		entityManager.persist(soporte);
	}

	@Override
	public void update(Soporte soporte) {
		entityManager.merge(soporte);
	}

	@Override
	public void delete(Soporte soporte) {
		entityManager.remove(soporte);
	}

	@Override
	public Soporte findById(Long id) {
		return entityManager.find(Soporte.class,id);
	}

	@Override
	public List<Soporte> findAll() {
		String jpql="SELECT sop FROM Soporte sop";
		return entityManager.createQuery(jpql).getResultList();
	}
	
}