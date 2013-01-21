package com.dahg.project.ref.view.filter;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.view.AbstractManagedBean;
import com.dahg.project.ref.view.CurrentSession;

@ManagedBean
@SessionScoped
public class AuthorizationBean extends AbstractManagedBean {

	@EJB
	private UsuarioService service;
	@ManagedProperty("#{currentSession}")
	private CurrentSession sesion;
	
	public void isAuthorized(ComponentSystemEvent event) {
		FacesContext fc = getFacesContext();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
		
		String seccion=getFacesContext().getViewRoot().getViewId();
		if(seccion==null || seccion.isEmpty()) nav.performNavigation("no_auth");
		try {
			service.isAuthorized(seccion, sesion.getUser());
		} catch (ValidationException e) {
			addError(e.getMessage());
			//nav.performNavigation("no_auth");
			nav.handleNavigation(fc, null, "no_auth");
		}
	}

	public void setSesion(CurrentSession sesion) {
		this.sesion = sesion;
	}
	
	
}
