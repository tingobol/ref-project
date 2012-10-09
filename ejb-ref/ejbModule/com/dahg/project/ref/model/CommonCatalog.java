package com.dahg.project.ref.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CommonCatalog extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
