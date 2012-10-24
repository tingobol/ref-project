package com.dahg.project.ref.model.parameters;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LOGIC")
public class Logic extends Parametro implements IParametro<Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="logico")
	private Boolean valor;
	
	@Override	
	public Boolean getValor() {
		return valor;
	}

	@Override
	public void setValor(Boolean valor) {
		this.valor = valor;
	}
	
	

}
