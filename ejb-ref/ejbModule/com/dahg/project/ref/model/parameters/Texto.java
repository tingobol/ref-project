package com.dahg.project.ref.model.parameters;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEXTO")
public class Texto extends Parametro<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String texto;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
