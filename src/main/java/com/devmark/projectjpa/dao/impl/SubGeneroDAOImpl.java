/**
 * 
 */
package com.devmark.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.devmark.projectjpa.dao.ISubGeneroDAO;
import com.devmark.projectjpa.entity.SubGenero;

/**
 * @author marcos.hernandez
 * 
 * Clase que implementa el CRUD para las transacciones a la tabla de subgenero.
 *
 */
public class SubGeneroDAOImpl implements ISubGeneroDAO {
	
	/**
	 * Constante que crea un EntityManager para manejar los Entities de las clases mapeadas a la base de datos
	 */
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceProjectJPA");

	@Override
	public void save(SubGenero subGenero) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(subGenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.merge(subGenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(Long idSubGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsultado = em.find(SubGenero.class, idSubGenero);
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.remove(subGeneroConsultado);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public List<SubGenero> findAll() {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		@SuppressWarnings("unchecked")
		TypedQuery<SubGenero> query = (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
		
		return query.getResultList();
	}

	@Override
	public SubGenero findById(Long idSubGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsultado = em.find(SubGenero.class, idSubGenero);
		
		if (subGeneroConsultado == null) {
			throw new EntityNotFoundException("El registro consultado con el id: " + idSubGenero + " no arrojo ningún resultado.");
		}
		return subGeneroConsultado;
	}

}
