package com.dahg.project.ref.view.converter.impl;

import javax.faces.convert.FacesConverter;


import com.dahg.project.ref.model.impl.Departamento;
import com.dahg.project.ref.view.converter.AbstractConverter;


@FacesConverter(forClass=Departamento.class)
public class DepartamentoConverter extends AbstractConverter<Departamento>  {
	
	@Override
	protected String getBeanWithServiceCatalog() {
		return "departamentoMaintenance";
	}	

}
