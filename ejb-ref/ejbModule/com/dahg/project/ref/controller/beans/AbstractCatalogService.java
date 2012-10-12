package com.dahg.project.ref.controller.beans;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.ICatalog;

public abstract class AbstractCatalogService<T extends ICatalog> extends AbstractBean<T> implements CatalogService<T> {

	public void addNewCatalog(String descripcion) throws ControllerException{
		try {
			T newObj=getClazz().newInstance();
			newObj.setDescripcion(descripcion);
			super.persist(newObj);
		} catch (InstantiationException e) {
			throw new ControllerException(e);
		} catch (IllegalAccessException e) {
			throw new ControllerException(e);
		}
	}
	
	@Override
	public List<T> getAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(getClazz());
		Root<T> from = query.from(getClazz());
		
		CriteriaQuery<T> select = query.select(from).orderBy(cb.desc(from.get("id")));
		TypedQuery<T> tQuery = getEntityManager().createQuery(select);
		
		return  tQuery.getResultList();
	}

	@Override
	public void remove(T obj) {
		String sql="delete from "+getClazz().getName()+" c where c.id=:id";
		this.remove(sql,obj.getId());
	}

	@Override
	protected Class<T> getClazz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(T obj) throws ControllerException {
		T validate=getById(obj.getId());
		if (validate==null)
			super.persist(obj);
		else throw new ControllerException("Ya existe registro");
	}
	
	
	
}
