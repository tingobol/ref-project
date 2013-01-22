package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.local.ArticuloService;
import com.dahg.project.ref.model.impl.Articulo;

@Stateless
public class ArticuloServiceImpl extends AbstractCatalogService<Articulo> implements ArticuloService {

	@Override
	protected Class<Articulo> getClazz() {
		return Articulo.class;
	}

	@Override
	public void persist(Articulo obj) throws ControllerException {
		Articulo a = getById(obj.getId());
		if (a!=null) throw new ControllerException(getMessage("app.ejb.product_exist"));
		super.persist(obj);
	}
	
	

}
