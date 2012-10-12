package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
public class Departamento extends AbtractCatalog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Municipio> municipios;
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
		

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="departamento",targetEntity=Municipio.class)
	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}	
	
}