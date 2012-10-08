package com.dahg.project.ref.model;

import javax.persistence.*;


/**
 * The persistent class for the profesion database table.
 * 
 */
@Entity
public class Profesion implements ICatalogo {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	public Profesion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public Object getPrimaryKey() {
		return id;
	}

}