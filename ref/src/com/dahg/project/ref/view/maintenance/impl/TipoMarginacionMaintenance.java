package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.TipoMarginacionService;
import com.dahg.project.ref.model.impl.TipoMarginacion;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class TipoMarginacionMaintenance extends AbstractCatalogBean<TipoMarginacion> {

	@EJB
	private TipoMarginacionService service;
	
	@Override
	public CatalogService<TipoMarginacion> getService() {
		return service;
	}

}
