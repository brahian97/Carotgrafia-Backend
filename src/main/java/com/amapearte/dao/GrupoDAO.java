package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.amapearte.modelo.Grupo;

@Repository
@Scope("singleton")
public class GrupoDAO implements IGrupoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Grupo grupo) {
		entityManager.persist(grupo);
	}

	@Override
	public void update(Grupo grupo) {
		entityManager.merge(grupo);		
	}

	@Override
	public void delete(Grupo grupo) {
		entityManager.remove(grupo);	
	}

	@Override
	public Grupo findById(Long idgrupo) {
		return entityManager.find(Grupo.class, idgrupo);
	}

	@Override
	public List<Grupo> findAll() {
		String jpql="SELECT gru FROM Grupo gru";
		return entityManager.createQuery(jpql).getResultList();
	}
}