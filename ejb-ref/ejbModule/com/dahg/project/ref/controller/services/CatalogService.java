package com.dahg.project.ref.controller.services;

import java.util.List;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.model.ICatalogo;

public interface CatalogService<T extends ICatalogo> extends Service<T> {

	List<T> getAll();
	void addNewCatalog(String descripcion) throws ControllerException;
	
}
