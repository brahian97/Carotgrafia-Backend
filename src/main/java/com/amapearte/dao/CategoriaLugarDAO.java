package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.amapearte.modelo.CategoriaLugar;

@Repository
@Scope("singleton")
public class CategoriaLugarDAO implements ICategoriaLugarDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(CategoriaLugar categoriaLugar) {
		entityManager.persist(categoriaLugar);
	}

	@Override
	public void update(CategoriaLugar categoriaLugar) {
		entityManager.merge(categoriaLugar);		
	}

	@Override
	public void delete(CategoriaLugar categoriaLugar) {
		entityManager.remove(categoriaLugar);	
	}

	@Override
	public CategoriaLugar findById(Long idcategorialugar) {
		return entityManager.find(CategoriaLugar.class, idcategorialugar);
	}

	@Override
	public List<CategoriaLugar> findAll() {
		String jpql="SELECT cateLu FROM CategoriaLugar cateLu";
		return entityManager.createQuery(jpql).getResultList();
	}
}