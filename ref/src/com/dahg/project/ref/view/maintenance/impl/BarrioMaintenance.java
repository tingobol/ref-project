package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.BarrioService;
import com.dahg.project.ref.model.impl.Barrio;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class BarrioMaintenance extends AbstractCatalogBean<Barrio> {

	@EJB
	private BarrioService service;

	@Override
	public CatalogService<Barrio> getService() {
		return service;
	}

}
