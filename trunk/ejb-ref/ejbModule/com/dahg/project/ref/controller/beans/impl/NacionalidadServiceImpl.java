package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.NacionalidadService;
import com.dahg.project.ref.model.Nacionalidad;

@Stateless
public class NacionalidadServiceImpl extends AbstractCatalogService<Nacionalidad> implements NacionalidadService {

	@Override
	protected Class<Nacionalidad> getClazz() {
		return Nacionalidad.class;
	}

}
