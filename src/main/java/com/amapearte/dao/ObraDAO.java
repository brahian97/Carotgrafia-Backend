package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Obra;

@Repository
@Scope("singleton")
public class ObraDAO implements IObraDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Obra obra) {
		entityManager.persist(obra);
	}

	@Override
	public void update(Obra obra) {
		entityManager.merge(obra);		
	}

	@Override
	public void delete(Obra obra) {
		entityManager.remove(obra);	
	}

	@Override
	public Obra findById(Long id) {
		return entityManager.find(Obra.class, id);
	}

	@Override
	public List<Obra> findAll() {
		String jpql="SELECT ob FROM Obra ob";
		return entityManager.createQuery(jpql).getResultList();
	}
}