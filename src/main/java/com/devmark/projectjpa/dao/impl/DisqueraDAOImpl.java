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

import com.devmark.projectjpa.dao.IDisqueraDAO;
import com.devmark.projectjpa.entity.Disquera;

/**
 * @author marcos.hernandez
 * 
 * Clase que implementa las transacciones CRUD para la trabla de disquera.
 *
 */
public class DisqueraDAOImpl implements IDisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceProjectJPA");

	@Override
	public void save(Disquera disquera) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		try {
			em.persist(disquera);
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
	public void update(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(disquera);
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
	public void delete(Long idDisquera) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera registroConsultado = em.find(Disquera.class, idDisquera);
				
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(registroConsultado);
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
	public List<Disquera> findAll() {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		@SuppressWarnings("unchecked")
		TypedQuery<Disquera> query = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return query.getResultList();
	}

	@Override
	public Disquera findById(Long idDisquera) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera registroConsultado = em.find(Disquera.class, idDisquera);
		
		if (registroConsultado == null) {
			throw new EntityNotFoundException("El registro consultado con el id: " + idDisquera + " no arrojo ningún resultado.");
		} 
		
		return registroConsultado;
		
	}

}
