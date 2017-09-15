package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


import com.amapearte.modelo.ArteInteresArtista;





@Repository
@Scope("singleton")
public class ArteInteresArtistaDAO implements IArteInteresArtistaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ArteInteresArtista arteInteresArtista) {
		entityManager.persist(arteInteresArtista);
		
	}

	@Override
	public void update(ArteInteresArtista arteInteresArtista) {
		entityManager.merge(arteInteresArtista);		
	}

	@Override
	public void delete(ArteInteresArtista arteInteresArtista) {
		entityManager.remove(arteInteresArtista);		
	}

	@Override
	public ArteInteresArtista findById(Long id) {
		return entityManager.find(ArteInteresArtista.class, id);
	}

	@Override
	public List<ArteInteresArtista> findAll() {
		String jpql="SELECT artIntArt FROM ArteInteresArtista artIntArt";
		return entityManager.createQuery(jpql).getResultList();
	}
	
	
	
}