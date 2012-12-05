package com.dahg.project.ref.view.system;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.impl.Usuario;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class UserMaintenance extends AbstractManagedBean {

	@EJB
	private UsuarioService service;
	private List<Usuario> all;
	private String id;
	
	@PostConstruct
	public void init() {
		all = service.getAll();
	}
	
	public String add() {
		if(id==null || id.isEmpty()) addError("Debe ingresar un ID");
		else {
			Usuario usuario = new Usuario();
			usuario.setUsername(getId());
			try {
				service.persist(usuario);
				all.clear();
				all.addAll(service.getAll());
				RequestContext rc = getRequestContext();
				rc.execute("edit.hide()");
			} catch (ControllerException e) {
				addError(e);
			}
		}
		return null;
	}
	
	public void editUser(RowEditEvent evt) {
		Usuario u = (Usuario) evt.getObject();
		service.merge(u);
		addInfo(String.format("%s actualizado", u.getUsername()));
	}
	
	public List<Usuario> getAll() {
		return all;
	}
	public void setAll(List<Usuario> all) {
		this.all = all;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
