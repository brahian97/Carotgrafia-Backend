package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.TipoSoporte;

@Repository
@Scope("singleton")
public class TipoSoporteDAO implements ITipoSoporteDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TipoSoporte tipoSoporte) {
		entityManager.persist(tipoSoporte);
	}

	@Override
	public void update(TipoSoporte tipoSoporte) {
		entityManager.merge(tipoSoporte);
	}

	@Override
	public void delete(TipoSoporte tipoSoporte) {
		entityManager.remove(tipoSoporte);
	}

	@Override
	public TipoSoporte findById(Long id) {
		return entityManager.find(TipoSoporte.class,id);
	}

	@Override
	public List<TipoSoporte> findAll() {
		String jpql="SELECT tipSop FROM TipoSoporte tipSop";
		return entityManager.createQuery(jpql).getResultList();
	}
}