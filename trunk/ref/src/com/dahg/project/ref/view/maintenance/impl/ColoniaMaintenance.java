package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.ColoniaService;
import com.dahg.project.ref.model.Colonia;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class ColoniaMaintenance extends AbstractCatalogBean<Colonia> {

	@EJB
	private ColoniaService service;
	
	@Override
	public CatalogService<Colonia> getService() {
		return service;
	}

}
