package com.dahg.project.ref.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the articulo database table.
 * 
 */
@Entity
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String texto;

	public Articulo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}