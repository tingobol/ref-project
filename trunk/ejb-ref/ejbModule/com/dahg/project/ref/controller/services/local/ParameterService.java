package com.dahg.project.ref.controller.services.local;

import com.dahg.project.ref.model.parameters.Parametro;

public interface ParameterService<T extends Parametro>  {
	
	T getParametro(String nemonico);
	
}
