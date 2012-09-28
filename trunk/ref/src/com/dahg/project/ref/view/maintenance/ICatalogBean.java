package com.dahg.project.ref.view.maintenance;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.ICatalogo;

public interface ICatalogBean<T extends ICatalogo> {

	CatalogService<T> getService();
}
