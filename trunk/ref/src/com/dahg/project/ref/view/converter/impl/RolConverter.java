package com.dahg.project.ref.view.converter.impl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.dahg.project.ref.controller.services.local.RolService;
import com.dahg.project.ref.model.impl.Rol;
import com.dahg.project.ref.view.system.UserMaintenance;

@FacesConverter(forClass=Rol.class)
public class RolConverter implements Converter {

	private RolService getService() {
		String beanName="userMaintenance";
		String elExpression=String.format("#%s%s%s","{",beanName,"}");		
		FacesContext ctx= FacesContext.getCurrentInstance();
		UserMaintenance bean = (UserMaintenance) ctx.getApplication().evaluateExpressionGet(ctx, elExpression, Object.class);
		return bean.getRolService();
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Rol r = getService().getById(value);
		return r;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Rol r = (Rol) value;
		return r.getId();
	}

}
