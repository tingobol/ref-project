package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;
import com.dahg.project.ref.model.ICatalog;


/**
 * The persistent class for the idioma database table.
 * 
 */
@Entity
public class Idioma extends AbtractCatalog implements ICatalog {

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

}