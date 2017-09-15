package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.ReferenciaObraUsuario;

@Repository
@Scope("singleton")
public class ReferenciaObraUsuarioDAO implements IReferenciaObraUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ReferenciaObraUsuario referenciaObraUsuario) {
		entityManager.persist(referenciaObraUsuario);
	}

	@Override
	public void update(ReferenciaObraUsuario referenciaObraUsuario) {
		entityManager.merge(referenciaObraUsuario);
	}

	@Override
	public void delete(ReferenciaObraUsuario referenciaObraUsuario) {
		entityManager.remove(referenciaObraUsuario);
	}

	@Override
	public ReferenciaObraUsuario findById(Long id) {
		return entityManager.find(ReferenciaObraUsuario.class,id);
	}

	@Override
	public List<ReferenciaObraUsuario> findAll() {
		String jpql="SELECT refou FROM ReferenciaObraUsuario refou";
		return entityManager.createQuery(jpql).getResultList();
	}
}