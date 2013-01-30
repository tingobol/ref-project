package com.dahg.project.ref.model.constants;

public enum DocumentType {

	CEDULA("CEDULA"),
	DUI("DUI"),
	PASAPORTE("PASAPORTE"),
	CARNE_MINORIDAD("CARNE_MINORIDAD"),
	CARNE_ELECTORAL("CARNE_ELECTROAL"),
	PARTIDA_NACIMIENTO("PARTIDA_NACIMIENTO"),
	CEDULA_VECINDAD("CEDULA_VECINDAD"),
	DOCUMENTO_EXTRANJERO("DOCUMENTO_EXTRANJERO"),
	CARNE_RESIDENTE("CARNE_RESIDENTE")
	;
	
	private String value;
	
	DocumentType(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
}
