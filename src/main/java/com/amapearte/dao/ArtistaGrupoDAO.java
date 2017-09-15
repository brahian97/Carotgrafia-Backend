package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.ArtistaGrupo;

@Repository
@Scope("singleton")
public class ArtistaGrupoDAO implements IArtistaGrupoDAO {
	

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ArtistaGrupo artistaGrupo) {
		entityManager.persist(artistaGrupo);
		
	}

	@Override
	public void update(ArtistaGrupo artistaGrupo) {
		entityManager.merge(artistaGrupo);		
	}

	@Override
	public void delete(ArtistaGrupo artistaGrupo) {
		entityManager.remove(artistaGrupo);		
	}

	@Override
	public ArtistaGrupo findById(Long id) {
		return entityManager.find(ArtistaGrupo.class, id);
	}

	@Override
	public List<ArtistaGrupo> findAll() {
		String jpql="SELECT artGrupo FROM ArtistaGrupo artGrupo";
		return entityManager.createQuery(jpql).getResultList();
	}
}