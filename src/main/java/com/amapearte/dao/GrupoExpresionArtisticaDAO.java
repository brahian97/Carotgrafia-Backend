package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.GrupoExpresionArtistica;

@Repository
@Scope("singleton")
public class GrupoExpresionArtisticaDAO implements IGrupoExpresionArtisticaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(GrupoExpresionArtistica grupoExpresionArtistica) {
		entityManager.persist(grupoExpresionArtistica);
	}

	@Override
	public void update(GrupoExpresionArtistica grupoExpresionArtistica) {
		entityManager.merge(grupoExpresionArtistica);		
	}

	@Override
	public void delete(GrupoExpresionArtistica grupoExpresionArtistica) {
		entityManager.remove(grupoExpresionArtistica);			
	}

	@Override
	public GrupoExpresionArtistica findById(Long id) {
		return entityManager.find(GrupoExpresionArtistica.class, id);
	}

	@Override
	public List<GrupoExpresionArtistica> findAll() {
		String jpql="SELECT gruExpA FROM GrupoExpresionArtistica gruExpA";
		return entityManager.createQuery(jpql).getResultList();
	}
}