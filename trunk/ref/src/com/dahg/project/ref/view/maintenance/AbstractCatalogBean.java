package com.dahg.project.ref.view.maintenance;

import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.ICatalogo;
import com.dahg.project.ref.view.AbstractManagedBean;

public abstract class AbstractCatalogBean<T extends ICatalogo> extends AbstractManagedBean {
		
	protected abstract CatalogService<T> getService();
	private List<T> all;
	private T selected;
	
	@PostConstruct
	public void init() {
		setAll(getService().getAll());
	}
	
	public void add() {
		try {
			getService().addNewCatalog("-----");
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
		getService().remove(selected);
		all.clear();
		all.addAll(getService().getAll());
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
	
	
}
