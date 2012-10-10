package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.ProfesionService;
import com.dahg.project.ref.model.impl.Profesion;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class ProfesionMaintenance extends AbstractCatalogBean<Profesion> {

	@EJB
	private ProfesionService service;
	
	@Override
	public CatalogService<Profesion> getService() {
		return service;
	}

}
