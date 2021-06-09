/**
 * 
 */
package com.devmark.projectjpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author marcos.hernandez
 * 
 * Clase entity que sera mapeada a una tabla disquera en la base de datos con JPA.
 *
 */
@Entity
@Table(name = "disquera")
public class Disquera {
	
	/**
	 * Identificador unico de cada registro de la disquera
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDisquera")
	private Integer idDisquera;
	/**
	 * Descripcion de la disquera
	 */
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	/**
	 * Fecha de creacion de la disquera
	 */
	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;
	/**
	 * Fecha de modificacion de la disquera
	 */
	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;
	/**
	 * Estatus de la diquera
	 */
	@Column(name = "estatus")
	private boolean estatus;
	/**
	 * @return the idDisquera
	 */
	public Integer getIdDisquera() {
		return idDisquera;
	}
	/**
	 * @param idDisquera the idDisquera to set
	 */
	public void setIdDisquera(Integer idDisquera) {
		this.idDisquera = idDisquera;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
}
