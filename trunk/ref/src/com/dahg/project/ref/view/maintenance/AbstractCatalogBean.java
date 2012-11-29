package com.dahg.project.ref.view.maintenance;

import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.model.ICatalog;
import com.dahg.project.ref.view.AbstractManagedBean;

public abstract class AbstractCatalogBean<T extends ICatalog> extends AbstractManagedBean implements ICatalogBean<T> {		
	
	private List<T> all;
	private T selected;
	private String descripcion;
	
	@PostConstruct
	public void init() {
		setAll(getService().getAll());
	}
	
	public void add() {
		try {
			getService().addNewCatalog(descripcion);
			descripcion=null;
			all.clear();
			all.addAll(getService().getAll());
			RequestContext rc = getRequestContext();
			rc.execute("edit.hide()");
			
		} catch (ControllerException e) {
			addError(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void edit(RowEditEvent evt) {
		T current = (T) evt.getObject();
		getService().merge(current);
	}
	
	@SuppressWarnings("unchecked")
	public void select(SelectEvent evt) {
		T current = (T) evt.getObject();
		setSelected(current);
	}
	
	public String delete() {
		if (selected==null) {
			addWarn("Debe seleccionar un registro");
			return null;
		}
		
		all.clear();
		getService().remove(selected);
		
		all.addAll(getService().getAll());
		selected = null;
		return null;
	}

	public List<T> getAll() {
		return all;
	}

	public void setAll(List<T> all) {
		this.all = all;
	}

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
