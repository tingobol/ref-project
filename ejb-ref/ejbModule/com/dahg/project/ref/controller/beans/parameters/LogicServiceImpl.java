package com.dahg.project.ref.controller.beans.parameters;

import javax.ejb.Stateless;

import com.dahg.project.ref.controller.services.local.LogicService;
import com.dahg.project.ref.model.parameters.Logic;

@Stateless
public class LogicServiceImpl extends AbstractParameterServiceImpl<Logic> implements LogicService {

	@Override
	protected Class<Logic> getClazz() {
		return Logic.class;
	}

}
