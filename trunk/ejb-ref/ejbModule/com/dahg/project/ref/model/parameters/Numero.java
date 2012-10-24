package com.dahg.project.ref.model.parameters;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NUMBER")
public class Numero extends Parametro implements IParametro<Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="numero")
	private Double valor;
	
	@Override	
	public Double getValor() {
		return valor;
	}

	@Override
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
