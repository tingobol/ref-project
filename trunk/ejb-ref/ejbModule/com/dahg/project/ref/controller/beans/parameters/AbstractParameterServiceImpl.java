package com.dahg.project.ref.controller.beans.parameters;

import javax.persistence.Query;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.services.local.ParameterService;
import com.dahg.project.ref.model.constants.ParameterType;
import com.dahg.project.ref.model.parameters.Parametro;

public abstract class AbstractParameterServiceImpl<T extends Parametro> extends AbstractBean<T> implements ParameterService<T> {

	protected abstract ParameterType getType();
	
	@Override
	public T getParametro(String nemonico) {
		String sql="select p from "+getType().getValue()+" p where p.nemonico=:id";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", nemonico);
		return (T) query.getSingleResult();
	}

	@Override
	public void remove(T obj) {
		String sql="delete from "+getType().getValue()+" p where p.nemonico=:id";
		this.remove(sql, obj.getNemonico());
	}

}
