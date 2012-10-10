package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.CantonService;
import com.dahg.project.ref.model.impl.Canton;

@Stateless
public class CantonServiceImpl extends AbstractCatalogService<Canton> implements CantonService {

	@Override
	protected Class<Canton> getClazz() {
		return Canton.class;
	}

}
