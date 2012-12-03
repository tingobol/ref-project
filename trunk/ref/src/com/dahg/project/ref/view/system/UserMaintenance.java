package com.dahg.project.ref.view.system;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.impl.Usuario;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class UserMaintenance extends AbstractManagedBean {

	@EJB
	private UsuarioService service;
	private List<Usuario> all;
	
	@PostConstruct
	public void init() {
		all = service.getAll();
	}
	
	public List<Usuario> getAll() {
		return all;
	}
	public void setAll(List<Usuario> all) {
		this.all = all;
	}
}
