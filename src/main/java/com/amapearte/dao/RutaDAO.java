package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Ruta;

@Repository
@Scope("singleton")
public class RutaDAO implements IRutaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Ruta ruta) {
		entityManager.persist(ruta);
	}

	@Override
	public void update(Ruta ruta) {
		entityManager.merge(ruta);
	}

	@Override
	public void delete(Ruta ruta) {
		entityManager.remove(ruta);
	}

	@Override
	public Ruta findById(Long id) {
		return entityManager.find(Ruta.class,id);
	}

	@Override
	public List<Ruta> findAll() {
		String jpql="SELECT rut FROM Ruta rut";
		return entityManager.createQuery(jpql).getResultList();
	}
}