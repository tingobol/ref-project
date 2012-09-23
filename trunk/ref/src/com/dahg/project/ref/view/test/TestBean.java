package com.dahg.project.ref.view.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.local.DepartamentoService;
import com.dahg.project.ref.model.Departamento;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractManagedBean {

	@EJB
	private DepartamentoService service;
	
	private List<Departamento> all;
	
	@PostConstruct
	public void init() {
		all = service.getAll();
	}

	public List<Departamento> getAll() {
		return all;
	}

	public void setAll(List<Departamento> all) {
		this.all = all;
	}
	
	
}
