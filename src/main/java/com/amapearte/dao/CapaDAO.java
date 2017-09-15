package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.amapearte.modelo.Capa;

@Repository
@Scope("singleton")
public class CapaDAO implements ICapaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Capa capa) {
		entityManager.persist(capa);
		
	}

	@Override
	public void update(Capa capa) {
		entityManager.merge(capa);		
	}

	@Override
	public void delete(Capa capa) {
		entityManager.remove(capa);	
		
	}

	@Override
	public Capa findById(Long idcapa) {
		return entityManager.find(Capa.class, idcapa);
	}

	@Override
	public List<Capa> findAll() {
		String jpql="SELECT cap FROM Capa cap";
		return entityManager.createQuery(jpql).getResultList();
	}
}