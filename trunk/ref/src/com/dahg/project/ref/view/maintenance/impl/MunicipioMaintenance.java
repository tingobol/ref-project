package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.MunicipioService;
import com.dahg.project.ref.model.Municipio;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class MunicipioMaintenance extends AbstractCatalogBean<Municipio> {

	@EJB
	private MunicipioService service;
	
	@Override
	public CatalogService<Municipio> getService() {
		return service;
	}

}
