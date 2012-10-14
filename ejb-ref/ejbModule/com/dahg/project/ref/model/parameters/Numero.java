package com.dahg.project.ref.model.parameters;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NUMBER")
public class Numero extends Parametro<Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double numero;
	public Double getNumero() {
		return numero;
	}
	public void setNumero(Double numero) {
		this.numero = numero;
	}

}
