package com.dahg.project.ref.model.constants;

public enum ParameterType {

	
	TEXTO("Texto"),
	LOGIC("Logic"),
	NUMERO("Numero");
	
	private final String value;
	
	private ParameterType(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
}
