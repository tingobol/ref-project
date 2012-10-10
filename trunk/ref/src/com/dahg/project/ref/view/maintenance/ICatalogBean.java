package com.dahg.project.ref.view.maintenance;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.AbtractCatalog;
import com.dahg.project.ref.model.ICatalog;

public interface ICatalogBean<T extends ICatalog> {

	CatalogService<T> getService();
}
