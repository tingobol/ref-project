package com.dahg.project.ref.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.dahg.project.ref.model.ICatalogo;
import com.dahg.project.ref.view.maintenance.ICatalogBean;

public abstract class AbstractConverter<T extends ICatalogo> implements Converter, ICatalogBean<T> {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Integer id = Integer.valueOf(value);
		return getService().getById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {		
		return ((T) value).getPrimaryKey().toString();
	}
	
	
	
}
