package com.dahg.project.ref.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.impl.Usuario;

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
			return "inicio";
		} catch (ValidationException e) {
			addWarn(e.getMessage());
			return null;
		} catch (ControllerException e) {
			addError(e);
			return null;
		}
	}
	
	public String logout() {
		user.setUsername(null);
		user.setPassword(null);
		user.setPasswordWithoutEncrypt(null);
		user.setNombre(null);
		user.setApellido(null);
		user.setUsuarioRols(null);
		return null;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public boolean isEnable() {
		return user.getUsername()!=null && !user.getUsername().isEmpty();
	}
	
}
