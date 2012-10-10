package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.BarrioService;
import com.dahg.project.ref.model.impl.Barrio;

@Stateless
public class BarrioServiceImpl extends AbstractCatalogService<Barrio> implements BarrioService {

	@Override
	protected Class<Barrio> getClazz() {
		return Barrio.class;
	}

}
