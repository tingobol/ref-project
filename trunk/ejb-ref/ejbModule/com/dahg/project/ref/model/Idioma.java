package com.dahg.project.ref.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the idioma database table.
 * 
 */
@Entity
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	public Idioma() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}