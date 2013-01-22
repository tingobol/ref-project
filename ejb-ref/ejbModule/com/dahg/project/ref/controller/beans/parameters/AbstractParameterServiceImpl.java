package com.dahg.project.ref.controller.beans.parameters;

import javax.persistence.Query;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.local.ParameterService;
import com.dahg.project.ref.model.parameters.Parametro;

public abstract class AbstractParameterServiceImpl<T extends Parametro> extends AbstractBean<T> implements ParameterService<T> {

	protected String getType() {
		return getClazz().getName();
	}
	
	@Override
	public T getParametro(String nemonico) throws ControllerException {
		T param;
		String sql="select p from "+getType()+" p where p.nemonico=:id";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("id", nemonico);
		param = (T) query.getSingleResult();
		if (param==null) throw new ControllerException(String.format(getMessage("app.ejb.parameter_service.no_exist"), nemonico));
		return param;
	}

	@Override
	public void remove(T obj) {
		String sql="delete from "+getType()+" p where p.nemonico=:id";
		this.remove(sql, obj.getNemonico());
	}

}
