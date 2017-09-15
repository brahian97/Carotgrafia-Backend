package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.RutaExpresionArtistica;

@Repository
@Scope("singleton")
public class RutaExpresionArtisticaDAO implements IRutaExpresionArtisticaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(RutaExpresionArtistica rutaExpresionArtistica) {
		entityManager.persist(rutaExpresionArtistica);
	}

	@Override
	public void update(RutaExpresionArtistica rutaExpresionArtistica) {
		entityManager.merge(rutaExpresionArtistica);
	}

	@Override
	public void delete(RutaExpresionArtistica rutaExpresionArtistica) {
		entityManager.remove(rutaExpresionArtistica);
	}

	@Override
	public RutaExpresionArtistica findById(Long id) {
		return entityManager.find(RutaExpresionArtistica.class,id);
	}

	@Override
	public List<RutaExpresionArtistica> findAll() {
		String jpql="SELECT rutExpA FROM RutaExpresionArtistica rutExpA";
		return entityManager.createQuery(jpql).getResultList();
	}
}