package com.dahg.project.ref.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String apellido;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy="usuario")
	private List<UsuarioRol> usuarioRols;

	public Usuario() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(List<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

}