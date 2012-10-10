package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;
import com.dahg.project.ref.model.ICatalog;


/**
 * The persistent class for the nacionalidad database table.
 * 
 */
@Entity
public class Nacionalidad extends AbtractCatalog implements ICatalog {

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