package com.dahg.project.ref.controller.beans.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dahg.project.ref.controller.beans.AbstractCatalogService;
import com.dahg.project.ref.controller.services.local.DepartamentoService;
import com.dahg.project.ref.model.impl.Departamento;

@Stateless
public class DepartamentoServiceImpl extends AbstractCatalogService<Departamento> implements DepartamentoService {

	@Override
	protected Class<Departamento> getClazz() {
		return Departamento.class;
	}

	@Override
	public List<Departamento> searchFromDescription(String desc) {
		String sql="select d from Departamento d where upper(d.descripcion) like :desc";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("desc", desc.toUpperCase()+"%");
		return query.getResultList();
	}
}
