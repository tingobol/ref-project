package com.dahg.project.ref.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.Usuario;
import com.dahg.project.ref.model.UsuarioRol;

@ManagedBean
@SessionScoped
public class CurrentSession extends AbstractManagedBean {

	@EJB
	private UsuarioService service;
	
	private Usuario user;
	
	@PostConstruct
	public void init() {
		user = new Usuario();
	}
	
	public String validate() {
		try {
			user = service.validate(user.getUsername(), user.getPasswordWithoutEncrypt());
			user.setPasswordWithoutEncrypt(null);
			return "main";
		} catch (ValidationException e) {
			addWarn(e.getMessage());
			return null;
		} catch (ControllerException e) {
			addError(e);
			return null;
		}
	}	
	
	public boolean isAuthorized(String roles) {
		boolean result=false;
		
		if(roles==null || roles.isEmpty()) return false;
		
		if(roles.length()>0 && isEnable() && !user.getUsuarioRols().isEmpty()) {
			String[] arrayRoles=roles.split(",");
			for(String rol:arrayRoles)
				if(hasUserRol(rol)) return true;			
		}
		
		return result;
	}
	
	private boolean hasUserRol(String rol) {		
		for(UsuarioRol userRol:user.getUsuarioRols()) 
			if(userRol.getRol().getId().equals(rol) || userRol.getRol().getId().equals("ADMIN")) return true;
		return false;		
	}
	
	
	
	public boolean isEnable() {
		return !user.getUsername().isEmpty();
	}
	
	public String logout() {
		user = new Usuario();		
		return "login";
	}
	
	public Usuario getUser() {
		return user;
	}
	
	
}
