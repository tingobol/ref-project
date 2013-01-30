package com.dahg.project.ref.model.impl.pk;

import java.io.Serializable;

import com.dahg.project.ref.model.constants.BookType;

public class LibroId implements Serializable{

	private int id;
	private BookType tipo;

	public LibroId(int id, BookType tipo) {
		this.id=id;
		this.tipo=tipo;
	}
}
