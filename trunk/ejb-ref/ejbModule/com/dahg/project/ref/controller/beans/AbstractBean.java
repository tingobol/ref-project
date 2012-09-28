package com.dahg.project.ref.controller.beans;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dahg.project.ref.controller.persist.SpringPersistence;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.controller.util.Decrypt;
import com.dahg.project.ref.model.IEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Interceptors(SpringBeanAutowiringInterceptor.class)
public abstract class AbstractBean<T extends IEntity> implements Service<T> {

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

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void remove(T obj) {
		getEntityManager().remove(getEntityManager().contains(obj)?obj:getEntityManager().merge(obj));		
	}
	
	public Decrypt getDecrypt() {
		return decrypt;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	protected void remove(String sql,T obj) {
		Query q=getEntityManager().createQuery(sql).setParameter("id", obj.getPrimaryKey());
		q.executeUpdate();
	}
	
	
}
