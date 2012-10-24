package com.dahg.project.ref.model.parameters;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEXTO")
public class Texto extends Parametro implements IParametro<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="texto")
	private String valor;
	
	@Override	
	public String getValor() {
		return valor;
	}

	@Override
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
