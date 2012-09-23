package com.dahg.project.ref.controller.beans;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.dahg.project.ref.controller.persist.SpringPersistence;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.controller.util.Decrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Interceptors(SpringBeanAutowiringInterceptor.class)
public abstract class AbstractBean<T> implements Service<T> {

	@Autowired
	@Qualifier("persistence")
	private SpringPersistence persistence;
	
	@Autowired
	@Qualifier("decrypt")
	private Decrypt decrypt;
	
	protected EntityManager getEntityManager() {
		return persistence.getEntityManager();
	}
	
	protected abstract Class<T> getClazz();

	@Override
	public T getById(Object id) {
		return getEntityManager().find(getClazz(), id);
	}

	@Override
	public void persist(T obj) {
		getEntityManager().persist(obj);
	}

	@Override
	public void merge(T obj) {
		getEntityManager().merge(obj);
	}

	@Override
	public void remove(T obj) {
		getEntityManager().remove(getEntityManager().merge(obj));		
	}
	
	public Decrypt getDecrypt() {
		return decrypt;
	}
	
	
}
