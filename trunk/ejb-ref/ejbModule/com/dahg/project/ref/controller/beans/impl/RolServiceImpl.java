package com.dahg.project.ref.controller.beans.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.local.RolService;
import com.dahg.project.ref.model.impl.Rol;
import com.dahg.project.ref.model.impl.UsuarioRol;

@Stateless
public class RolServiceImpl extends AbstractBean<Rol> implements RolService {	

	@EJB
	private RolUsuarioServiceImpl usuarioRolService;
	
	@Override
	protected Class<Rol> getClazz() {
		return Rol.class;
	}
	
	@Override
	public void remove(Rol obj) {
		// TODO Auto-generated method stub		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> getAll() {
		String sql="select r From Rol r";
		return getEntityManager().createQuery(sql).getResultList();
	}

	@Override
	public void removeUsuarioRol(UsuarioRol us) {
		usuarioRolService.remove(us);
	}

	@Override
	public void addPermission(UsuarioRol us) throws ControllerException {
		usuarioRolService.persist(us);
	}

}
