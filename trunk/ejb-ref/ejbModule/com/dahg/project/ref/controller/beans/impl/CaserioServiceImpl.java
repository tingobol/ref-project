package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.CaserioService;
import com.dahg.project.ref.model.Caserio;

@Stateless
public class CaserioServiceImpl extends AbstractCatalogService<Caserio> implements CaserioService {

	@Override
	protected Class<Caserio> getClazz() {
		return Caserio.class;
	}

}
