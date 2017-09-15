package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.amapearte.modelo.Biografia;

@Repository
@Scope("singleton")
public class BiografiaDAO implements IBiografiaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Biografia biografia) {
		entityManager.persist(biografia);
		
	}

	@Override
	public void update(Biografia biografia) {
		entityManager.merge(biografia);		
	}

	@Override
	public void delete(Biografia biografia) {
		entityManager.remove(biografia);		
	}

	@Override
	public Biografia findById(Long id) {
		return entityManager.find(Biografia.class, id);
	}

	@Override
	public List<Biografia> findAll() {
		String jpql="SELECT bio FROM Biografia bio";
		return entityManager.createQuery(jpql).getResultList();
	}
	
}