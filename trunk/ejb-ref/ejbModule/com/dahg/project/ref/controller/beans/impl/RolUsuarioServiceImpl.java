package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.model.impl.UsuarioRol;

@LocalBean
@Singleton
public class RolUsuarioServiceImpl extends AbstractBean<UsuarioRol>{

	
	@Override
	protected Class<UsuarioRol> getClazz() {
		return UsuarioRol.class;
	}
	
	@Override
	public void remove(UsuarioRol obj) {
		String sql="delete from UsuarioRol us where us.id=:id";
		this.remove(sql, obj.getId());
	}	

}
