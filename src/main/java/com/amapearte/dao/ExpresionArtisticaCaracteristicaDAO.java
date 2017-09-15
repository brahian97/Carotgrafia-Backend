package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.amapearte.modelo.ExpresionArtisticaCaracteristica;

@Repository
@Scope("singleton")
public class ExpresionArtisticaCaracteristicaDAO implements IExpresionArtisticaCaracteristicaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) {
		entityManager.persist(expresionArtisticaCaracteristica);
	}

	@Override
	public void update(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) {
		entityManager.merge(expresionArtisticaCaracteristica);	
	}

	@Override
	public void delete(ExpresionArtisticaCaracteristica expresionArtisticaCaracteristica) {
		entityManager.remove(expresionArtisticaCaracteristica);	
	}

	@Override
	public ExpresionArtisticaCaracteristica findById(Long idexpresionartistica) {
		return entityManager.find(ExpresionArtisticaCaracteristica.class, idexpresionartistica);
	}

	@Override
	public List<ExpresionArtisticaCaracteristica> findAll() {
		String jpql="SELECT expArtC FROM ExpresionArtisticaCaracteristica expArtC";
		return entityManager.createQuery(jpql).getResultList();
	}
}