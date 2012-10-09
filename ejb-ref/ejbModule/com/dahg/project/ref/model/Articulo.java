package com.dahg.project.ref.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the articulo database table.
 * 
 */
@Entity
public class Articulo implements Serializable {

	@Id	
	private Integer numero;
	private String descripcion;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}