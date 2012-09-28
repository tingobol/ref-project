package com.dahg.project.ref.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@Column(name="username",precision=20)
	private String username;

	private String apellido;

	private String nombre;

	private String password;
	
	@Transient
	private String passwordWithoutEncrypt;

	//bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy="usuario",fetch=FetchType.EAGER)
	private List<UsuarioRol> usuarioRols;

	public Usuario() {
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPasswordWithoutEncrypt() {
		return passwordWithoutEncrypt;
	}

	public void setPasswordWithoutEncrypt(String passwordWithoutEncrypt) {
		this.passwordWithoutEncrypt = passwordWithoutEncrypt;
	}
	
	@Transient
	public String getCompleteName() {
		return nombre+" "+apellido;
	}

	@Override
	public Object getPrimaryKey() {
		return username;
	}
	

}