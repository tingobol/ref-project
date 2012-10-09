package com.dahg.project.ref.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.CommonCatalog;
import com.dahg.project.ref.view.maintenance.AbstractCatalogBean;
import com.dahg.project.ref.view.maintenance.ICatalogBean;

public abstract class AbstractConverter<T extends CommonCatalog> implements Converter, ICatalogBean<T> {

	protected abstract String getBeanName();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {	
		
		Integer id = Integer.valueOf(value);
		return getService().getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		T item = (T) value;
		String id = item.getId().toString();
		return id;
	}
	
	@SuppressWarnings("unchecked")
	public CatalogService<T> getService() {
		FacesContext ctx= FacesContext.getCurrentInstance();
		AbstractCatalogBean<T> bean = (AbstractCatalogBean<T>) ctx.getApplication().evaluateExpressionGet(ctx, "#{"+getBeanName()+"}", Object.class);
		return bean.getService();
	}
	
	
}
