package com.dahg.project.ref.model.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autorizacion_vista")
public class AutorizacionVista implements Serializable {

	@Id
	private String seccion;
	private String key;
	private String roles;
	
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seccion == null) ? 0 : seccion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorizacionVista other = (AutorizacionVista) obj;
		if (seccion == null) {
			if (other.seccion != null)
				return false;
		} else if (!seccion.equals(other.seccion))
			return false;
		return true;
	}
	
	
}
