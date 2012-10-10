package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.IdiomaService;
import com.dahg.project.ref.model.impl.Idioma;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class IdiomaMaintenance extends AbstractCatalogBean<Idioma> {

	@EJB
	private IdiomaService service;
	
	@Override
	public CatalogService<Idioma> getService() {
		return service;
	}

}
