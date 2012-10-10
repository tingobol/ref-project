package com.dahg.project.ref.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbtractCatalog extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
