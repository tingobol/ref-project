package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.IdiomaService;
import com.dahg.project.ref.model.Idioma;

@Stateless
public class IdiomaServiceImpl extends AbstractCatalogService<Idioma> implements IdiomaService {

	@Override
	protected Class<Idioma> getClazz() {
		return Idioma.class;
	}

}
