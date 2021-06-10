/**
 * 
 */
package com.devmark.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devmark.projectjpa.dao.IDisqueraDAO;
import com.devmark.projectjpa.dao.impl.DisqueraDAOImpl;
import com.devmark.projectjpa.entity.Disquera;

/**
 * @author marcos.hernandez
 *
 */
class DisqueraDAOImplTest {
	
	private IDisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.DisqueraDAOImpl#save(com.devmark.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testSave() {
		
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Albino Records");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.save(disquera);
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.DisqueraDAOImpl#update(com.devmark.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testUpdate() {
		Disquera registroConsultado = this.disqueraDAO.findById(9L);
		
		registroConsultado.setDescripcion("AT Records");
		
		if (registroConsultado != null) {
			this.disqueraDAO.update(registroConsultado);
		}
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.DisqueraDAOImpl#delete(com.devmark.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testDelete() {
		this.disqueraDAO.delete(9L);
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.DisqueraDAOImpl#findAll()}.
	 */
	@Test
	void testFindAll() {
		List<Disquera> registrosConsultados = this.disqueraDAO.findAll();
		
		assertTrue(registrosConsultados.size() > 0);
		
		registrosConsultados.forEach(registroDisquera -> {
			System.out.println("Descripción: " + registroDisquera.getDescripcion());
			System.out.println("Fecha de Creación: " + registroDisquera.getFechaCreacion());
		});
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.DisqueraDAOImpl#findById(java.lang.Long)}.
	 */
	@Test
	void testFindById() {
		Disquera registroConsultado = this.disqueraDAO.findById(9L);
		
		System.out.println("Registro: ");
		System.out.println("id = " + registroConsultado.getIdDisquera());
		System.out.println("Descripción = " + registroConsultado.getDescripcion());
		System.out.println("Fecha de Creación = " + registroConsultado.getFechaCreacion());
		System.out.println("Estatus = " + registroConsultado.isEstatus());
	}

}
