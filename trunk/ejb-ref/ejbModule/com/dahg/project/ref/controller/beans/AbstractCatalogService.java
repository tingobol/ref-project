package com.dahg.project.ref.controller.beans;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.dahg.project.ref.controller.services.CatalogService;

public abstract class AbstractCatalogService<T> extends AbstractBean<T> implements CatalogService<T> {

	@Override
	public List<T> getAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Object> query = cb.createQuery();
		Root<Object> from = (Root<Object>) query.from(getClazz());
		
		CriteriaQuery select = query.select(from);
		TypedQuery<Object> tQuery = getEntityManager().createQuery(select);
		
		return (List<T>) tQuery.getResultList();
	}

}
