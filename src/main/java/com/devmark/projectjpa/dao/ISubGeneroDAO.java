/**
 * 
 */
package com.devmark.projectjpa.dao;

import java.util.List;

import com.devmark.projectjpa.entity.SubGenero;

/**
 * @author marcos.hernandez
 * 
 * Interface DAO que realiza el CRUD con JPA para la tabla subgenero.
 *
 */
public interface ISubGeneroDAO {

	/**
	 * Metodo que permite guardar un subgenero
	 * @param subGenero {@link SubGenero} objeto a guardar
	 */
	public abstract void save(SubGenero subGenero);
	
	/**
	 * Metodo que permite actualizar un subgenero
	 * @param subGenero {@link SubGenero} objeto a actualizar
	 */
	public abstract void update(SubGenero subGenero);
	
	/**
	 * Metodo que permite eliminar un subgenero
	 * @param idSubGenero {@link Long} llave que elimina el objeto
	 */
	public abstract void delete(Long idSubGenero);

	/**
	 * Metodo que permite consultar la lista de todos los registros de subgenero
	 * @return {@link List<SubGenero>} lista de objetos de tipo SubGenero
	 */
	public abstract List<SubGenero> findAll();
	
	/**
	 * Metodo que permite consultar por llave un registro de subgenero
	 * @param idSubGenero llave que permite consultar un registro
	 * @return {@link SubGenero} objeto de tipo SubGenero 
	 */
	public abstract SubGenero findById(Long idSubGenero);

}
