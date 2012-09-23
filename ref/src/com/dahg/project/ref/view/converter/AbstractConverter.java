package com.dahg.project.ref.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.dahg.project.ref.controller.services.Service;

public abstract class AbstractConverter<T> implements Converter {

	protected abstract Service<T> getService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Integer id = Integer.valueOf(value);
		return getService().getById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {		
		return value.toString();
	}
	
	
	
}
