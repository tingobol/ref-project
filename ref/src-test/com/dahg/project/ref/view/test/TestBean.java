package com.dahg.project.ref.view.test;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.dahg.project.ref.controller.services.local.TextoService;
import com.dahg.project.ref.model.parameters.Texto;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractManagedBean {
	
	@EJB
	private TextoService pService;
	
	private String texto;
	private Texto parametro;
	
	@PostConstruct
	public void init() {
		parametro = pService.getParametro("TEST");
	}
	
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

	public Texto getParametro() {
		return parametro;
	}

	public void setParametro(Texto parametro) {
		this.parametro = parametro;
	}
	
	
}
