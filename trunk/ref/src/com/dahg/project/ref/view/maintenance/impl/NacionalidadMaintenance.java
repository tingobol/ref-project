package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.NacionalidadService;
import com.dahg.project.ref.model.impl.Nacionalidad;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class NacionalidadMaintenance extends AbstractCatalogBean<Nacionalidad> {

	@EJB
	private NacionalidadService service;
	
	@Override
	public CatalogService<Nacionalidad> getService() {
		return service;
	}

}
