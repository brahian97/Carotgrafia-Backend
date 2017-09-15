package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Pais;

@Repository
@Scope("singleton")
public class PaisDAO implements IPaisDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Pais pais) {
		entityManager.persist(pais);
	}

	@Override
	public void update(Pais pais) {
		entityManager.merge(pais);
		
	}

	@Override
	public void delete(Pais pais) {
		entityManager.remove(pais);
	}

	@Override
	public Pais findById(Long id) {
		return entityManager.find(Pais.class,id);
	}

	@Override
	public List<Pais> findAll() {
		String jpql="SELECT p FROM Pais p";
		return entityManager.createQuery(jpql).getResultList();
	}
}