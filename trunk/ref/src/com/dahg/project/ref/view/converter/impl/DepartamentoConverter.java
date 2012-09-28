package com.dahg.project.ref.view.converter.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.convert.FacesConverter;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.DepartamentoService;
import com.dahg.project.ref.model.Departamento;
import com.dahg.project.ref.view.converter.AbstractConverter;

@ManagedBean
@FacesConverter("departamentoConverter")
public class DepartamentoConverter extends AbstractConverter<Departamento>  {

	@EJB
	private DepartamentoService service;

	@Override
	public CatalogService<Departamento> getService() {
		return service;
	}

}
