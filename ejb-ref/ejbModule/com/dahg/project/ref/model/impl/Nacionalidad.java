package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;


/**
 * The persistent class for the nacionalidad database table.
 * 
 */
@Entity
public class Nacionalidad extends AbtractCatalog {

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