package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.amapearte.modelo.Usuario;

@Repository
@Scope("singleton")
public class UsuarioDAO implements IUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		entityManager.remove(usuario);
	}

	@Override
	public Usuario findById(Long id) {
		return entityManager.find(Usuario.class,id);
	}

	@Override
	public List<Usuario> findAll() {
		String jpql="SELECT user FROM Usuario user";
		return entityManager.createQuery(jpql).getResultList();
	}
}