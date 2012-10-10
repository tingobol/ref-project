package com.dahg.project.ref.view.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractManagedBean {
	
	private String texto;
	
	public boolean test(String arg) {		
		return !(arg.indexOf("ADMIN")>-1);
	}
	
	public String actionNormal() {
		RequestContext.getCurrentInstance().execute("prueba.hide()");
		return null;
	}	
	
	public String ejecutar() {
		System.out.println("Ejecutar");
		return null;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
