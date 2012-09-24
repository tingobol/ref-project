package com.dahg.project.ref.controller.beans;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.Catalogo;

public abstract class AbstractCatalogService<T extends Catalogo> extends AbstractBean<T> implements CatalogService<T> {

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
	public void addNewCatalog(String description) throws ControllerException {
		try {
			T newObj = getClazz().newInstance();
			newObj.setDescripcion(description);
			this.merge(newObj);			
		} catch (InstantiationException e) {
			throw new ControllerException(e);
		} catch (IllegalAccessException e) {			
			throw new ControllerException(e);
		}
		
	}
	
	

}
