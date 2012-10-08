package com.dahg.project.ref.controller.services.local;

import java.util.List;

import javax.ejb.Local;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.Departamento;

@Local
public interface DepartamentoService extends CatalogService<Departamento> {

	List<Departamento> searchFromDescription(String desc);
}
