package com.dahg.project.ref.view.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractManagedBean {
	
	private String texto;
	
	public boolean test(String arg) {		
		return !(arg.indexOf("ADMIN")>-1);
	}
	
	public String actionNormal() {
		texto="ESTOY EN ACTION NORMAL";
		return null;
	}	
	
	public void actionListener(ActionEvent evt) {
		texto="ESTOY EN ACTION LISTENER";
	}
	
	public String getTexto() {
		return texto;
	}
}
