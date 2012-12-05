package com.dahg.project.ref.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.ICatalog;
import com.dahg.project.ref.view.maintenance.ICatalogBean;

public abstract class AbstractConverter<T extends ICatalog> implements Converter, ICatalogBean<T> {

	protected abstract String getBeanWithServiceCatalog();
	
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
		String elExpression=String.format("#%s%s%s","{",getBeanWithServiceCatalog(),"}");		
		FacesContext ctx= FacesContext.getCurrentInstance();
		ICatalogBean<T> bean = (ICatalogBean<T>) ctx.getApplication().evaluateExpressionGet(ctx, elExpression, Object.class);
		return bean.getService();
	}
	
	
}
