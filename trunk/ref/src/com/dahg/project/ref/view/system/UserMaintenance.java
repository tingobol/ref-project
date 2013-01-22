package com.dahg.project.ref.view.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
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
	
	private String currentPassword;
	private String passUno;
	private String passDos;
	
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
		roles.clear();
		roles.addAll(rolService.getAll());
		Usuario u=(Usuario) evt.getObject();
		selected = u;
		List<Rol> target = new ArrayList<Rol>();
		for(UsuarioRol ur:u.getUsuarioRols()) {
			Rol r = ur.getRol();
			if (roles.remove(r)) target.add(r);
		}
			
		picklistModel = new DualListModel<Rol>(roles, target);
		return null;
	}
	
	public String savePermisos() {
		List<Rol> target=picklistModel.getTarget();
		for(UsuarioRol us:selected.getUsuarioRols()) {
			if(!target.contains(us.getRol()))
				rolService.removeUsuarioRol(us);
		}
		for(Rol r:target) {
			UsuarioRol us=new UsuarioRol(selected,r);
			try {
				rolService.addPermission(us);
			} catch (ControllerException e) {
				addError(e);
			}
		}
		all.clear();
		all.addAll(service.getAll());
		
		RequestContext rc = getRequestContext();
		rc.execute("permisos.hide()");
		addInfo(String.format("%s actualizado", selected.getUsername()));
		return null;
	}
	
	public String changePassword() {
		if (passUno==null || passDos ==null || passUno.isEmpty() || passDos.isEmpty())
			addError("Debe introducir la contraseña nueva");
		else if(!passUno.equals(passDos))
			addError("Las contraseñas no coinciden");
		else {
			try {
				service.changePassword(selected, passUno);
			} catch (ValidationException e) {
				addError(e);
			}
			all.clear();
			all.addAll(service.getAll());
			addInfo(String.format("%s actualizado", selected.getUsername()));
			RequestContext rc = getRequestContext();
			rc.execute("pass.hide()");
		}
		return null;
	}
	
	public String changePasswordByUser() {		
		try {
			if (!passUno.equals(passDos))
				throw new ValidationException("Las contraseñas no coinciden");
			service.changePassword(selected, currentPassword, passUno);
			addInfo(String.format("%s contraseña actualizada", selected.getUsername()));
			passUno="";
			passDos="";
			currentPassword="";
		} catch (ValidationException e) {
			addError(e);
		}		
		return null;
	}

	public String removeUsuario() {
		service.remove(selected);
		all.clear();
		all.addAll(service.getAll());
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

	public String getPassUno() {
		return passUno;
	}

	public void setPassUno(String passUno) {
		this.passUno = passUno;
	}

	public String getPassDos() {
		return passDos;
	}

	public void setPassDos(String passDos) {
		this.passDos = passDos;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	
	
}
