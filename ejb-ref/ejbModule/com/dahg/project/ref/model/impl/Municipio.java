package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;
import com.dahg.project.ref.model.ICatalog;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
public class Municipio extends AbtractCatalog implements ICatalog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Departamento departamento;
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	

	@Override
	public void setId(Integer id) {
		this.id=id;
	}

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="fk_departamento")	
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}