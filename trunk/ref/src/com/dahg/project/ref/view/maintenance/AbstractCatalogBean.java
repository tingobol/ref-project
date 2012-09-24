package com.dahg.project.ref.view.maintenance;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.Catalogo;
import com.dahg.project.ref.view.AbstractManagedBean;
import com.sun.org.apache.xml.internal.resolver.Catalog;

public abstract class AbstractCatalogBean<T extends Catalogo> extends AbstractManagedBean {
		
	protected abstract CatalogService<T> getService();
	private List<T> all;
	
	@PostConstruct
	public void init() {
		setAll(getService().getAll());
	}
	
	public void add(ActionEvent evt) {
		try {
			getService().addNewCatalog("-----");
		} catch (ControllerException e) {
			addError(e);
		}
	}

	public List<T> getAll() {
		return all;
	}

	public void setAll(List<T> all) {
		this.all = all;
	}
	
	
}
