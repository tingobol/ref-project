package com.dahg.project.ref.view.maintenance.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.DepartamentoService;
import com.dahg.project.ref.controller.services.local.MunicipioService;
import com.dahg.project.ref.model.Departamento;
import com.dahg.project.ref.model.Municipio;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class MunicipioMaintenance extends AbstractCatalogBean<Municipio> {

	@EJB
	private MunicipioService service;
	@EJB
	private DepartamentoService departamentoService;
	private Departamento selectedDepartament;
	
	@Override
	public CatalogService<Municipio> getService() {
		return service;
	}	
	
	@Override
	public void add() {Municipio newMunicipio=new Municipio();
		newMunicipio.setDescripcion(getDescripcion());
		newMunicipio.setDepartamento(selectedDepartament);
		getService().persist(newMunicipio);
		setDescripcion("");
		getAll().clear();
		getAll().addAll(getService().getAll());
	}

	public List<Departamento> complete(String desc) {
		return departamentoService.searchFromDescription(desc);
	}
	
	public Departamento getSelectedDepartament() {
		return selectedDepartament;
	}

	public void setSelectedDepartament(Departamento selectedDepartament) {
		this.selectedDepartament = selectedDepartament;
	}
	

}
