/**
 * 
 */
package com.devmark.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devmark.projectjpa.dao.ISubGeneroDAO;
import com.devmark.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.devmark.projectjpa.entity.Genero;
import com.devmark.projectjpa.entity.SubGenero;

/**
 * @author marcos.hernandez
 * 
 * Clase TEST para comprobar el funcionamiento de los metodos CRUD de subgenero.
 *
 */
class SubGeneroDAOImplTest {
	
	private ISubGeneroDAO subgeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.SubGeneroDAOImpl#save(com.devmark.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testSave() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Trash Metal");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		
		this.subgeneroDAO.save(subGenero);
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.SubGeneroDAOImpl#update(com.devmark.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testUpdate() {
		
		SubGenero subGeneroConsultado = this.subgeneroDAO.findById(7L);
		
		subGeneroConsultado.setDescripcion("trash metal");
		subGeneroConsultado.getGenero().setDescripcion("Metal");
		
		this.subgeneroDAO.update(subGeneroConsultado);
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.SubGeneroDAOImpl#delete(java.lang.Long)}.
	 */
	@Test
	void testDelete() {		
		this.subgeneroDAO.delete(7L);
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.SubGeneroDAOImpl#findAll()}.
	 */
	@Test
	void testFindAll() {
		
		List<SubGenero> subGeneros = this.subgeneroDAO.findAll();
		
		assertTrue(subGeneros.size() > 0);
		
		subGeneros.forEach(subGenero -> {
			System.out.println("Id Subgenero: " + subGenero.getIdSubGenero());
			System.out.println("Descripción: " + subGenero.getDescripcion());
			System.out.println("Género: " + subGenero.getGenero().getDescripcion());
		});
		
	}

	/**
	 * Test method for {@link com.devmark.projectjpa.dao.impl.SubGeneroDAOImpl#findById(java.lang.Long)}.
	 */
	@Test
	void testFindById() {
		this.subgeneroDAO.findById(7L);
	}

}
