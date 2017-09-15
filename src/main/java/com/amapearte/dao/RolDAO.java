package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Rol;

@Repository
@Scope("singleton")
public class RolDAO implements IRolDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Rol rol) {
		entityManager.persist(rol);
	}

	@Override
	public void update(Rol rol) {
		entityManager.merge(rol);
	}

	@Override
	public void delete(Rol rol) {
		entityManager.remove(rol);
	}

	@Override
	public Rol findById(Long id) {
		return entityManager.find(Rol.class,id);
	}

	@Override
	public List<Rol> findAll() {
		String jpql="SELECT rol FROM Rol rol";
		return entityManager.createQuery(jpql).getResultList();
	}
}