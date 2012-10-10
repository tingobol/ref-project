package com.dahg.project.ref.model.impl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_marginacion database table.
 * 
 */
@Entity
@Table(name="tipo_marginacion")
public class TipoMarginacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String texto;

	public TipoMarginacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}