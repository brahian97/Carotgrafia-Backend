package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Lugar;

@Repository
@Scope("singleton")
public class LugarDAO implements ILugarDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Lugar lugar) {
		entityManager.persist(lugar);
	}

	@Override
	public void update(Lugar lugar) {
		entityManager.merge(lugar);		
	}

	@Override
	public void delete(Lugar lugar) {
		entityManager.remove(lugar);	
	}

	@Override
	public Lugar findById(Long id) {
		return entityManager.find(Lugar.class, id);
	}

	@Override
	public List<Lugar> findAll() {
		String jpql="SELECT lug FROM Lugar lug";
		return entityManager.createQuery(jpql).getResultList();
	}
}