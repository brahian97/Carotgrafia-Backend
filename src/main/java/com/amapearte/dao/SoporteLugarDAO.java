package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.SoporteLugar;

@Repository
@Scope("singleton")
public class SoporteLugarDAO implements ISoporteLugarDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(SoporteLugar soporteLugar) {
		entityManager.persist(soporteLugar);
	}

	@Override
	public void update(SoporteLugar soporteLugar) {
		entityManager.merge(soporteLugar);
	}

	@Override
	public void delete(SoporteLugar soporteLugar) {
		entityManager.remove(soporteLugar);
	}

	@Override
	public SoporteLugar findById(Long id) {
		return entityManager.find(SoporteLugar.class,id);
	}

	@Override
	public List<SoporteLugar> findAll() {
		String jpql="SELECT sopLu FROM SoporteLugar sopLu";
		return entityManager.createQuery(jpql).getResultList();
	}
}