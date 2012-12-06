package com.dahg.project.ref.model.impl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_rol database table.
 * 
 */
@Entity
@Table(name="usuario_rol",uniqueConstraints=@UniqueConstraint(columnNames={"fk_usuario","fk_rol"}))
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="fk_rol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	public UsuarioRol() {
	}
	
	public UsuarioRol(Usuario usuario, Rol rol) {
		this.usuario=usuario;
		this.rol=rol;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}