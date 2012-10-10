package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.ParentescoService;
import com.dahg.project.ref.model.impl.Parentesco;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class ParentescoMaintenance extends AbstractCatalogBean<Parentesco> {

	@EJB
	private ParentescoService service;
	
	@Override
	public CatalogService<Parentesco> getService() {
		return service;
	}

}
