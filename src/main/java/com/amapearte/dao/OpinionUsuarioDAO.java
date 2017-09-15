package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.OpinionUsuario;

@Repository
@Scope("singleton")
public class OpinionUsuarioDAO implements IOpinionUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(OpinionUsuario opinionUsuario) {
		entityManager.persist(opinionUsuario);
		
	}

	@Override
	public void update(OpinionUsuario opinionUsuario) {
		entityManager.merge(opinionUsuario);	
		
	}

	@Override
	public void delete(OpinionUsuario opinionUsuario) {
		entityManager.remove(opinionUsuario);	
	}

	@Override
	public OpinionUsuario findById(Long id) {
		return entityManager.find(OpinionUsuario.class, id);
	}

	@Override
	public List<OpinionUsuario> findAll() {
		String jpql="SELECT op FROM OpinionUsuario op";
		return entityManager.createQuery(jpql).getResultList();
	}
}