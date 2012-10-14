package com.dahg.project.ref.model.parameters;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LOGIC")
public class Logic extends Parametro<Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean logico;
	public Boolean getLogico() {
		return logico;
	}
	public void setLogico(Boolean logic) {
		this.logico = logic;
	}
	
	

}
