package com.dahg.project.ref.view.maintenance;

import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.model.ICatalogo;
import com.dahg.project.ref.view.AbstractManagedBean;

public abstract class AbstractCatalogBean<T extends ICatalogo> extends AbstractManagedBean implements ICatalogBean<T> {		
	
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
			descripcion="";
			all.clear();
			all.addAll(getService().getAll());
		} catch (ControllerException e) {
			addError(e);
		}
	}
	
	public void edit(RowEditEvent evt) {
		T current = (T) evt.getObject();
		getService().merge(current);
	}
	
	public String delete() {
		if (selected==null) {
			addWarn("Debe seleccionar un registro");
			return null;
		}
		
		getService().remove(selected);
		all.clear();
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