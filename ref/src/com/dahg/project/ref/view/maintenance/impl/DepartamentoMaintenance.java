package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.DepartamentoService;
import com.dahg.project.ref.model.Departamento;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class DepartamentoMaintenance extends AbstractCatalogBean<Departamento> {

	@EJB
	private DepartamentoService service;
	
	@Override
	protected CatalogService<Departamento> getService() {
		return service;
	}

}
