package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.RutaObra;

@Repository
@Scope("singleton")
public class RutaObraDAO implements IRutaObraDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(RutaObra rutaObra) {
		entityManager.persist(rutaObra);
	}

	@Override
	public void update(RutaObra rutaObra) {
		entityManager.merge(rutaObra);
	}

	@Override
	public void delete(RutaObra rutaObra) {
		entityManager.remove(rutaObra);
	}

	@Override
	public RutaObra findById(Long id) {
		return entityManager.find(RutaObra.class,id);
	}

	@Override
	public List<RutaObra> findAll() {
		String jpql="SELECT rutOb FROM RutaObra rutOb";
		return entityManager.createQuery(jpql).getResultList();
	}
}