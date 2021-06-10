/**
 * 
 */
package com.devmark.projectjpa.dao;

import java.util.List;

import com.devmark.projectjpa.entity.Disquera;

/**
 * @author marcos.hernandez
 * 
 * Interface que genera el DAO para las transacciones del CRUD a la tabla disquera.
 *
 */
public interface IDisqueraDAO {
	
	public abstract void save(Disquera disquera);
	
	public abstract void update(Disquera disquera);
	
	public abstract void delete(Long idDisquera);
	
	public abstract List<Disquera> findAll();
	
	public abstract Disquera findById(Long idDisquera);
	
}
