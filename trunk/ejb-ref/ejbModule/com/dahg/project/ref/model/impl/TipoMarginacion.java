package com.dahg.project.ref.model.impl;


import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;




/**
 * The persistent class for the tipo_marginacion database table.
 * 
 */
@Entity
@Table(name="tipo_marginacion")
public class TipoMarginacion extends AbtractCatalog {
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