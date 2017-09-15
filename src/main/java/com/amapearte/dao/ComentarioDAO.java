package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.Comentario;

@Repository
@Scope("singleton")
public class ComentarioDAO implements IComentarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Comentario comentario) {
		entityManager.persist(comentario);
	}

	@Override
	public void update(Comentario comentario) {
		entityManager.merge(comentario);		
	}

	@Override
	public void delete(Comentario comentario) {
		entityManager.remove(comentario);	
	}

	@Override
	public Comentario findById(Long idcomentario) {
		return entityManager.find(Comentario.class, idcomentario);
	}

	@Override
	public List<Comentario> findAll() {
		String jpql="SELECT com FROM Comentario com";
		return entityManager.createQuery(jpql).getResultList();
	}
}