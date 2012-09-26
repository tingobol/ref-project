package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;
import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.DepartamentoService;
import com.dahg.project.ref.model.Departamento;

@Stateless
public class DepartamentoServiceImpl extends AbstractCatalogService<Departamento> implements DepartamentoService {

	@Override
	protected Class<Departamento> getClazz() {
		return Departamento.class;
	}
}
