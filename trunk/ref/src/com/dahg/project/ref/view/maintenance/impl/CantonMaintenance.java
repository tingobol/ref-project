package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.CantonService;
import com.dahg.project.ref.model.impl.Canton;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class CantonMaintenance extends AbstractCatalogBean<Canton> {

	@EJB
	private CantonService service;
	
	@Override
	public CatalogService<Canton> getService() {
		return service;
	}

}
