package com.dahg.project.ref.model;

import javax.persistence.*;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
public class Municipio extends CommonCatalog {

//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="fk_departamento")
	private Departamento departamento;
	
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}