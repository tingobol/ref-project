package com.dahg.project.ref.model.constants;

public enum BookType {
	ADOPCION("ADOPCION"),
	DEFUNCION("DEFUNCION"),
	DIVORCIO("DIVORCIO"),
	JUICIO("JUICIO"),
	MARGINACION("MARGINACION"),
	MATRIMONIO("MATRIMONIO"),
	MODIFICACION("MODIFICACION"),
	NACIDO_MUERTO("NACIDO_MUERTO"),
	NACIMIENTO("NACIMIENTO"),
	REPOSICION("REPOSICION")
	;
	
	private String value;
	
	BookType(String value) {
		this.value=value;		
	}

	public String getValue() {
		return value;
	}
	
	
}
