package com.dahg.project.ref.controller.beans.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.services.local.RolService;
import com.dahg.project.ref.model.impl.Rol;

@Stateless
public class RolServiceImpl extends AbstractBean<Rol> implements RolService {	

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

}
