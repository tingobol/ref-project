package com.dahg.project.ref.controller.services;

import java.util.List;

public interface CatalogService<T> extends Service<T> {

	List<T> getAll();
}
