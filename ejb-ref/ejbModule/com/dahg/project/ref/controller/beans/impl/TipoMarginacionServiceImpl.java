package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.TipoMarginacionService;
import com.dahg.project.ref.model.impl.TipoMarginacion;

@Stateless
public class TipoMarginacionServiceImpl extends AbstractCatalogService<TipoMarginacion> implements TipoMarginacionService{

	@Override
	protected Class<TipoMarginacion> getClazz() {
		return TipoMarginacion.class;
	}

}
