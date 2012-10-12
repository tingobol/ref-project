package com.dahg.project.ref.view.maintenance.impl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.controller.services.local.ArticuloService;
import com.dahg.project.ref.model.impl.Articulo;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;

@ManagedBean
@ViewScoped
public class ArticuloMaintenance extends AbstractCatalogBean<Articulo> {
	
	private Integer id;

	@EJB
	private ArticuloService service;
	
	@Override
	public CatalogService<Articulo> getService() {
		return service;
	}

	@Override
	public void add() {
		Articulo articulo = new Articulo();
		articulo.setId(getId());
		try {
			getService().persist(articulo);
			getAll().clear();
			getAll().addAll(getService().getAll());
			setId(null);
			RequestContext rc = getRequestContext();
			rc.execute("edit.hide()");
		} catch (ControllerException e) {
			addError(e);
		}
		
	}
	
	public String editLaw() {
		getService().merge(getSelected());
		addInfo("Articulo modificado");
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
