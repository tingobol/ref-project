package com.dahg.project.ref.view.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.picklist.PickList;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.local.RolService;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.impl.Rol;
import com.dahg.project.ref.model.impl.Usuario;
import com.dahg.project.ref.model.impl.UsuarioRol;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class UserMaintenance extends AbstractManagedBean {

	@EJB
	private UsuarioService service;
	@EJB
	private RolService rolService;
	private List<Usuario> all;
	private List<Rol> roles;
	private String id;
	private DualListModel<Rol> picklistModel;
	private Usuario selected;
	
	@PostConstruct
	public void init() {
		all = service.getAll();
		roles = rolService.getAll();
		picklistModel = new DualListModel<Rol>();
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
	
	public String populateRoles(SelectEvent evt) {
		Usuario u=(Usuario) evt.getObject();
		List<Rol> target = new ArrayList<Rol>();
		for(UsuarioRol ur:u.getUsuarioRols())
			target.add(ur.getRol());
		picklistModel = new DualListModel<Rol>(roles, target);
		return null;
	}
	
	public String savePermisos() {
		selected.getUsuarioRols().clear();
		service.merge(selected);
		List<UsuarioRol> permisos= new ArrayList<UsuarioRol>();
		for(Rol r:picklistModel.getTarget()) {
			UsuarioRol ur=new UsuarioRol();
			ur.setRol(r);
			ur.setUsuario(getSelected());
			permisos.add(ur);
		}
		selected.getUsuarioRols().addAll(permisos);
		service.merge(getSelected());
		RequestContext rc = getRequestContext();
		rc.execute("permisos.hide()");
		return null;
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

	public Usuario getSelected() {
		return selected;
	}

	public void setSelected(Usuario selected) {
		this.selected = selected;
	}

	public DualListModel<Rol> getPicklistModel() {
		return picklistModel;
	}

	public void setPicklistModel(DualListModel<Rol> picklistModel) {
		this.picklistModel = picklistModel;
	}

	public RolService getRolService() {
		return rolService;
	}
	
}
