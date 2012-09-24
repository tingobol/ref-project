package com.dahg.project.ref.controller.services;

import java.util.List;

import com.dahg.project.ref.controller.exception.ControllerException;

public interface CatalogService<T> extends Service<T> {

	List<T> getAll();
	
	void addNewCatalog(String description) throws ControllerException;
}
