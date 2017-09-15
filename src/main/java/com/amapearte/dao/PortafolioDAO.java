package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Pais;
import com.amapearte.modelo.Portafolio;

@Repository
@Scope("singleton")
public class PortafolioDAO implements IPortafolioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Portafolio portafolio) {
		entityManager.persist(portafolio);
		
	}

	@Override
	public void update(Portafolio portafolio) {
		entityManager.merge(portafolio);
		
	}

	@Override
	public void delete(Portafolio portafolio) {
		entityManager.remove(portafolio);
		
	}

	@Override
	public Portafolio findById(Long id) {
		return entityManager.find(Portafolio.class,id);
	}

	@Override
	public List<Portafolio> findAll() {
		String jpql="SELECT por FROM Portafolio por";
		return entityManager.createQuery(jpql).getResultList();
	}
}