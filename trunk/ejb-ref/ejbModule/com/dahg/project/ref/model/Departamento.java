package com.dahg.project.ref.model;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
public class Departamento extends Catalogo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="departamento")
	private List<Municipio> municipios;

}