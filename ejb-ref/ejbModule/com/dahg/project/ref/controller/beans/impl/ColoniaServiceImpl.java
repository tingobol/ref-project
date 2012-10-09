package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.ColoniaService;
import com.dahg.project.ref.model.Colonia;

@Stateless
public class ColoniaServiceImpl extends AbstractCatalogService<Colonia> implements ColoniaService {

	@Override
	protected Class<Colonia> getClazz() {
		return Colonia.class;
	}

}
