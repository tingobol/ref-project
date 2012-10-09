package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.beans.AbstractBean;
import com.dahg.project.ref.controller.services.local.ArticuloService;
import com.dahg.project.ref.model.Articulo;

@Stateless
public class ArticuloServiceImpl extends AbstractBean<Articulo> implements ArticuloService {

	@Override
	protected Class<Articulo> getClazz() {
		return Articulo.class;
	}
	
	@Override
	public void remove(Articulo obj) {
		String sql="delete a from Articulo where a.numero=:id";
		this.remove(sql, obj.getNumero());
	}	

}
