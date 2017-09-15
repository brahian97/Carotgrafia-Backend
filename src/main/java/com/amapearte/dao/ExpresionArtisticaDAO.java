package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.ExpresionArtistica;

@Repository
@Scope("singleton")
public class ExpresionArtisticaDAO implements IExpresionArtisticaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ExpresionArtistica expresionArtistica) {
		entityManager.persist(expresionArtistica);
	}

	@Override
	public void update(ExpresionArtistica expresionArtistica) {
		entityManager.merge(expresionArtistica);	
	}

	@Override
	public void delete(ExpresionArtistica expresionArtistica) {
		entityManager.remove(expresionArtistica);	
	}

	@Override
	public ExpresionArtistica findById(Long idexpresionartistica) {
		return entityManager.find(ExpresionArtistica.class, idexpresionartistica);
	}

	@Override
	public List<ExpresionArtistica> findAll() {
		String jpql="SELECT expArt FROM ExpresionArtistica expArt";
		return entityManager.createQuery(jpql).getResultList();
	}
}