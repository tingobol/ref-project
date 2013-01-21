package com.dahg.project.ref.controller.beans.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.controller.services.local.RolService;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.impl.AutorizacionVista;
import com.dahg.project.ref.model.impl.Usuario;
import com.dahg.project.ref.model.impl.UsuarioRol;

@Stateless
public class UsuarioServiceImpl extends AbstractBean<Usuario> implements UsuarioService {

	@EJB
	private RolService rolService;
	@EJB
	private AutorizacionServiceImpl autorizacionService;
	
	
	@Override
	protected Class<Usuario> getClazz() {
		return Usuario.class;
	}

	@Override
	public Usuario validate(String user, String pass) throws ValidationException,ControllerException {
		boolean existe = getById(user)!=null;
		if(!existe) throw new ValidationException("Usuario no existe");
		
		Usuario usuario=null;
		String jpql="Select u From Usuario u where u.username=:id and u.password=:pass";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("id", user);
		try {
			query.setParameter("pass", getDecrypt().hash(pass));
			usuario = (Usuario) query.getSingleResult();			
		} 
		catch(NoResultException e) {
			throw new ValidationException("Usuario o contraseña incorrectos");
		}
		catch (Exception e) {
			throw new ControllerException(e);
		}
		if (usuario.getUsuarioRols()==null || usuario.getUsuarioRols().isEmpty()) throw new ValidationException("Usuario deshabilitado");
		return usuario;
	}

	@Override
	public void remove(Usuario obj) {
		for(UsuarioRol ur:obj.getUsuarioRols())
			rolService.removeUsuarioRol(ur);
		String sql="delete from Usuario u where u.username=:id";
		this.remove(sql, obj.getUsername());
	}

	@Override
	public List<Usuario> getAll() {
		String query = "select u From Usuario u order by u.username";
		Query q = getEntityManager().createQuery(query);
		return q.getResultList();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void persist(Usuario obj) throws ControllerException {
		Usuario u = getById(obj.getUsername());
		if (u!=null) throw new ControllerException("ID en uso");
		try {
			String passTemporal = this.getDecrypt().hash(obj.getUsername());
			obj.setPassword(passTemporal);
			super.persist(obj);
		} catch (Exception e) {
			throw new ControllerException(e);
		}
		
	}

	@Override
	public void changePassword(Usuario usuario, String oldPassword, String newPassword) throws ValidationException {		
		try {
			validate(usuario.getUsername(), oldPassword);
			try {
				usuario.setPassword(getDecrypt().hash(newPassword));
			} catch (Exception e) {
				throw new ValidationException(e);
			}
			this.merge(usuario);			
		} catch (ControllerException e) {
			throw new ValidationException(e);
		}
	}

	@Override
	public void changePassword(Usuario usuario, String newPassword) throws ValidationException {					
		try {
			usuario.setPassword(getDecrypt().hash(newPassword));
		} catch (Exception e) {
			throw new ValidationException(e);
		}
		this.merge(usuario);	
	}

	@Override
	public void isAuthorized(String section,Usuario usuario) throws ValidationException {
		if(usuario.getUsername()==null || usuario.getUsername().isEmpty()) throw new ValidationException("Debe ingresar al sistema");
		AutorizacionVista auth = autorizacionService.getById(section);
		if (auth==null) throw new ValidationException(String.format("Seccion %s Deshabilitada",section));
		String[] roles = auth.getRoles().split(",");
		if (roles==null || roles.length==0) throw new ValidationException(String.format("Seccion %s Deshabilitada", section));
		for(String rol:roles)
			if (!hasUserRol(rol, usuario)) throw new ValidationException(String.format("El usuario %s no tiene permiso para ver %s", usuario.getUsername(),section));
	}
	
	private boolean hasUserRol(String rol,Usuario user) {
		for(UsuarioRol userRol:user.getUsuarioRols()) 
			if(userRol.getRol().getId().equals(rol) || userRol.getRol().getId().equals("ADMIN")) return true;
		return false;		
	}

	
	
	
}
