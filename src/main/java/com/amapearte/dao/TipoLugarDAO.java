package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.amapearte.modelo.TipoLugar;

@Repository
@Scope("singleton")
public class TipoLugarDAO implements ITipoLugarDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TipoLugar tipoLugar) {
		entityManager.persist(tipoLugar);
	}

	@Override
	public void update(TipoLugar tipoLugar) {
		entityManager.merge(tipoLugar);
	}

	@Override
	public void delete(TipoLugar tipoLugar) {
		entityManager.remove(tipoLugar);
	}

	@Override
	public TipoLugar findById(Long id) {
		return entityManager.find(TipoLugar.class,id);
	}

	@Override
	public List<TipoLugar> findAll() {
		String jpql="SELECT tipLu FROM TipoLugar tipLu";
		return entityManager.createQuery(jpql).getResultList();
	}
}