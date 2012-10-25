package com.dahg.project.ref.controller.services.local;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.model.parameters.Parametro;

public interface ParameterService<T extends Parametro> extends Service<T> {
	
	T getParametro(String nemonico) throws ControllerException;
	
}
