package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.ParentescoService;
import com.dahg.project.ref.model.impl.Parentesco;

@Stateless
public class ParentescoServiceImpl extends AbstractCatalogService<Parentesco> implements ParentescoService {

	@Override
	protected Class<Parentesco> getClazz() {
		return Parentesco.class;
	}

}
