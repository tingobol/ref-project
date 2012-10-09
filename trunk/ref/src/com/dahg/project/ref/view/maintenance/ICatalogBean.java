package com.dahg.project.ref.view.maintenance;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.CommonCatalog;

public interface ICatalogBean<T extends CommonCatalog> {

	CatalogService<T> getService();
}
