package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.ExpresionAutor;

@Repository
@Scope("singleton")
public class ExpresionAutorDAO implements IExpresionAutorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ExpresionAutor expresionAutor) {
		entityManager.persist(expresionAutor);
	}

	@Override
	public void update(ExpresionAutor expresionAutor) {
		entityManager.merge(expresionAutor);	
	}

	@Override
	public void delete(ExpresionAutor expresionAutor) {
		entityManager.remove(expresionAutor);	
	}

	@Override
	public ExpresionAutor findById(Long idexpresionautor) {
		return entityManager.find(ExpresionAutor.class, idexpresionautor);
	}

	@Override
	public List<ExpresionAutor> findAll() {
		String jpql="SELECT expAut FROM ExpresionAutor expAut";
		return entityManager.createQuery(jpql).getResultList();
	}
}