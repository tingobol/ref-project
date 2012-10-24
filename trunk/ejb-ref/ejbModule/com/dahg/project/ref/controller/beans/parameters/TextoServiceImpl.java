package com.dahg.project.ref.controller.beans.parameters;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.services.local.TextoService;
import com.dahg.project.ref.model.parameters.Texto;

@Stateless
public class TextoServiceImpl extends AbstractParameterServiceImpl<Texto> implements TextoService {

	@Override
	protected Class<Texto> getClazz() {
		return Texto.class;
	}

	
}
