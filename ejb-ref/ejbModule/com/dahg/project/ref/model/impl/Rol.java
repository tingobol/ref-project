package com.dahg.project.ref.model.impl;

import javax.persistence.*;

import com.dahg.project.ref.model.AbtractCatalog;
import com.dahg.project.ref.model.ICatalog;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
public class Rol implements Serializable {

	private String id;
	private String descripcion;
	private List<UsuarioRol> usuarioRols;
	
	
	@Id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	

	@OneToMany(mappedBy="rol")
	public List<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(List<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

}