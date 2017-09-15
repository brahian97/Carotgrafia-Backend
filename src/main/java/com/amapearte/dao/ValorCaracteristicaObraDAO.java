package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.ValorCaracteristicaObra;

@Repository
@Scope("singleton")
public class ValorCaracteristicaObraDAO implements IValorCaracteristicaObraDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ValorCaracteristicaObra valorCaracteristicaObra) {
		entityManager.persist(valorCaracteristicaObra);
	}

	@Override
	public void update(ValorCaracteristicaObra valorCaracteristicaObra) {
		entityManager.merge(valorCaracteristicaObra);
	}

	@Override
	public void delete(ValorCaracteristicaObra valorCaracteristicaObra) {
		entityManager.remove(valorCaracteristicaObra);
	}

	@Override
	public ValorCaracteristicaObra findById(Long id) {
		return entityManager.find(ValorCaracteristicaObra.class,id);
	}

	@Override
	public List<ValorCaracteristicaObra> findAll() {
		String jpql="SELECT valCo FROM ValorCaracteristicaObra valCo";
		return entityManager.createQuery(jpql).getResultList();
	}
}