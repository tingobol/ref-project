package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.MunicipioService;
import com.dahg.project.ref.model.Municipio;

@Stateless
public class MunicipioServiceImpl extends AbstractCatalogService<Municipio> implements MunicipioService {

	@Override
	protected Class<Municipio> getClazz() {
		return Municipio.class;
	}

}
