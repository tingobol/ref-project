package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.model.impl.AutorizacionVista;

@Singleton
@LocalBean
public class AutorizacionServiceImpl extends AbstractBean<AutorizacionVista> {

	
	@Override
	protected Class<AutorizacionVista> getClazz() {
		return AutorizacionVista.class;
	}
	
	@Override
	public void remove(AutorizacionVista obj) {
		// TODO Auto-generated method stub
		
	}

	

}
