package com.amapearte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.amapearte.modelo.CaracteristicaObra;

@Repository
@Scope("singleton")
public class CaracteristicaObraDAO implements ICaracteristicaObraDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(CaracteristicaObra caracteristicaObra) {
		entityManager.persist(caracteristicaObra);
	}

	@Override
	public void update(CaracteristicaObra caracteristicaObra) {
		entityManager.merge(caracteristicaObra);		
		
	}

	@Override
	public void delete(CaracteristicaObra caracteristicaObra) {
		entityManager.remove(caracteristicaObra);		
	}

	@Override
	public CaracteristicaObra findById(Long idcaracteristicaobra) {
		return entityManager.find(CaracteristicaObra.class, idcaracteristicaobra);
	}

	@Override
	public List<CaracteristicaObra> findAll() {
		String jpql="SELECT carObra FROM CaracteristicaObra carObra";
		return entityManager.createQuery(jpql).getResultList();
	}
}