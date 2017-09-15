package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.CapaLugar;

@Repository
@Scope("singleton")
public class CapaLugarDAO implements ICapaLugarDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(CapaLugar capaLugar) {
		entityManager.persist(capaLugar);
		
	}

	@Override
	public void update(CapaLugar capaLugar) {
		entityManager.merge(capaLugar);		
		
	}

	@Override
	public void delete(CapaLugar capaLugar) {
		entityManager.remove(capaLugar);	
		
	}

	@Override
	public CapaLugar findById(Long idcapalugar) {
		return entityManager.find(CapaLugar.class, idcapalugar);
	}

	@Override
	public List<CapaLugar> findAll() {
		String jpql="SELECT capLu FROM CapaLugar capLu";
		return entityManager.createQuery(jpql).getResultList();
	}
}