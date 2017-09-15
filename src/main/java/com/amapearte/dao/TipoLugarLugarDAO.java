package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.TipoLugarLugar;

@Repository
@Scope("singleton")
public class TipoLugarLugarDAO implements ITipoLugarLugarDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TipoLugarLugar tipoLugarLugar) {
		entityManager.persist(tipoLugarLugar);
	}

	@Override
	public void update(TipoLugarLugar tipoLugarLugar) {
		entityManager.merge(tipoLugarLugar);
	}

	@Override
	public void delete(TipoLugarLugar tipoLugarLugar) {
		entityManager.remove(tipoLugarLugar);
	}

	@Override
	public TipoLugarLugar findById(Long id) {
		return entityManager.find(TipoLugarLugar.class,id);
	}

	@Override
	public List<TipoLugarLugar> findAll() {
		String jpql="SELECT tipLuLu FROM tipoLugarLugar tipLuLu";
		return entityManager.createQuery(jpql).getResultList();
	}
}