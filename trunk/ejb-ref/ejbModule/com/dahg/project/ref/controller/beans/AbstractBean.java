package com.dahg.project.ref.controller.beans;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dahg.project.ref.controller.persist.SpringPersistence;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.controller.util.Decrypt;
import com.dahg.project.ref.model.AbstractEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void persist(T obj) {
		getEntityManager().persist(obj);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void merge(T obj) {
		getEntityManager().merge(obj);
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	protected void remove(String sql,Object primaryKey) {
		Query q=getEntityManager().createQuery(sql).setParameter("id", primaryKey);
		q.executeUpdate();
	}
	
	public Decrypt getDecrypt() {
		return decrypt;
	}
	
	
}
