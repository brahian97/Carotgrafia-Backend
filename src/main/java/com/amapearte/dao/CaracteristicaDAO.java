package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.amapearte.modelo.Caracteristica;

@Repository
@Scope("singleton")
public class CaracteristicaDAO implements ICaracteristicaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Caracteristica caracteristica) {
		entityManager.persist(caracteristica);
	}

	@Override
	public void update(Caracteristica caracteristica) {
		entityManager.merge(caracteristica);		
		
	}

	@Override
	public void delete(Caracteristica caracteristica) {
		entityManager.remove(caracteristica);			
	}

	@Override
	public Caracteristica findById(Long idcaracteristica) {
		return entityManager.find(Caracteristica.class, idcaracteristica);
	}

	@Override
	public List<Caracteristica> findAll() {
		String jpql="SELECT car FROM Caracteristica car";
		return entityManager.createQuery(jpql).getResultList();
	}
}