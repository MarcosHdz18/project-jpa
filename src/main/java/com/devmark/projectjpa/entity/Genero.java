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
 * Clase entity que sera mapeada a una tabla genero en la base de datos con JPA
 *
 */
@Entity
@Table(name = "genero")
public class Genero {
	
	/**
	 * Identificador unico del genero
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGenero")
	private Long idGenero;
	
	/**
	 * Descripcion del genero	
	 */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**
	 * Fecha de creacion
	 */
	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;
	
	/**
	 * Fecha de modificacion
	 */
	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;
	
	/**
	 * Estatus del genero
	 */
	@Column(name = "estatus")
	private boolean estatus;

	/**
	 * @return the idGenero
	 */
	public Long getIdGenero() {
		return idGenero;
	}

	/**
	 * @param idGenero the idGenero to set
	 */
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
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