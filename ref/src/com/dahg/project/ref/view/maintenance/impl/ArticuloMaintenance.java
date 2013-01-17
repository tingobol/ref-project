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
		
		try {
			if (getId()==null) throw new ControllerException("Ingrese un numero de articulo");
			Articulo articulo = new Articulo();
			articulo.setId(getId());
			getService().persist(articulo);
			getAll().clear();
			getAll().addAll(getService().getAll());
			setId(null);
			RequestContext rc = getRequestContext();
			rc.execute("add.hide()");
		} catch (ControllerException e) {
			addError(e);
		}
		
	}
	
	@Override
	public String delete() {
		super.delete();
		return "articulo";
	}

	public String editLaw() {
		if(getSelected().getDescripcion()==null || getSelected().getDescripcion().isEmpty())
			addError("Debe ingresar una descripcion");
		else {
			getService().merge(getSelected());
			addInfo(String.format("Articulo %s modificado",getSelected().getId()));
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
