package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;


/**
 * The persistent class for the profesion database table.
 * 
 */
@Entity
public class Profesion extends AbtractCatalog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

}