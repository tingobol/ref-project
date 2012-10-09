package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.CaserioService;
import com.dahg.project.ref.model.Caserio;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class CaserioMaintenance extends AbstractCatalogBean<Caserio>{

	@EJB
	private CaserioService service;
	
	@Override
	public CatalogService<Caserio> getService() {
		return service;
	}

}
