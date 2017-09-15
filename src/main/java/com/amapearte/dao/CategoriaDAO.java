package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Categoria;

@Repository
@Scope("singleton")
public class CategoriaDAO implements ICategoriaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Categoria categoria) {
		entityManager.persist(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		entityManager.merge(categoria);		
	}

	@Override
	public void delete(Categoria categoria) {
		entityManager.remove(categoria);	
	}

	@Override
	public Categoria findById(Long idcategoria) {
		return entityManager.find(Categoria.class, idcategoria);
	}

	@Override
	public List<Categoria> findAll() {
		String jpql="SELECT cate FROM Categoria cate";
		return entityManager.createQuery(jpql).getResultList();
	}
}