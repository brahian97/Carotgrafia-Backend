package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.amapearte.modelo.Artista;

@Repository
@Scope("singleton")
public class ArtistaDAO implements IArtistaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Artista artista) {
		entityManager.persist(artista);
		
	}

	@Override
	public void update(Artista artista) {
		entityManager.merge(artista);		
	}

	@Override
	public void delete(Artista artista) {
		entityManager.remove(artista);		
	}

	@Override
	public Artista  findById(Long id) {
		return entityManager.find(Artista.class, id);
	}

	@Override
	public List<Artista> findAll() {
		String jpql="SELECT artista FROM Artista artista";
		return entityManager.createQuery(jpql).getResultList();
	}
}