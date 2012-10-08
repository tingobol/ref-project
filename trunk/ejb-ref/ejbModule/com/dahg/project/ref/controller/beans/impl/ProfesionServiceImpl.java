package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.ProfesionService;
import com.dahg.project.ref.model.Profesion;

@Stateless
public class ProfesionServiceImpl extends AbstractCatalogService<Profesion> implements ProfesionService {

	@Override
	protected Class<Profesion> getClazz() {
		return Profesion.class;
	}

}
