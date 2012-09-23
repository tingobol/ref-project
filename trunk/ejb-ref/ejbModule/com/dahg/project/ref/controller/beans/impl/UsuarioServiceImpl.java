package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.Usuario;

@Stateless
public class UsuarioServiceImpl extends AbstractBean<Usuario> implements UsuarioService {

	@Override
	protected Class<Usuario> getClazz() {
		return Usuario.class;
	}

	@Override
	public Usuario validate(String user, String pass) throws ValidationException,ControllerException {
		String jPQL="Select u From Usuario u where u.id=:user and u.pass=:pass";
		Query query = getEntityManager().createNativeQuery(jPQL, getClazz());
		query.setParameter("user", user);
		try {
			query.setParameter("pass", getDecrypt().hash(pass));
		} catch (Exception e) {
			throw new ControllerException(e);
		}
		Usuario usuario = (Usuario) query.getSingleResult();
		
		if(usuario==null) throw new ValidationException("Usuario o password incorrecto");
		
		return usuario;
	}

	
	
}
