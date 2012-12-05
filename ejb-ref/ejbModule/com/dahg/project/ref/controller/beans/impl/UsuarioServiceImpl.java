package com.dahg.project.ref.controller.beans.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.local.UsuarioService;
import com.dahg.project.ref.model.impl.Usuario;

@Stateless
public class UsuarioServiceImpl extends AbstractBean<Usuario> implements UsuarioService {

	@Override
	protected Class<Usuario> getClazz() {
		return Usuario.class;
	}

	@Override
	public Usuario validate(String user, String pass) throws ValidationException,ControllerException {
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
		
		return usuario;
	}

	@Override
	public void remove(Usuario obj) {
		String sql="delete from Usuario u.username=:id";
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

	
	
	
}
